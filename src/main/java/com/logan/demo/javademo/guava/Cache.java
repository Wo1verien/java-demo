package com.logan.demo.javademo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created 2020/1/3. 10:12 上午
 *
 * @author changzheng
 */
public class Cache {

    public static void main(String[] args) throws ExecutionException {
        //cache缓存
        //LoadingCache是Cache的缓存实现
        LoadingCache<String,String> cache = CacheBuilder.newBuilder()
                //设置缓存大小
                .maximumSize(1000)
                //设置到期时间
                .expireAfterWrite(10, TimeUnit.MINUTES)
                //设置缓存里的值两分钟刷新一次
                .refreshAfterWrite(2,TimeUnit.MINUTES)
                //开启缓存的统计功能
                .recordStats()
                //构建缓存
                .build(new CacheLoader<String, String>() {
                    //此处实现如果根据key找不到value需要去如何获取
                    @Override
                    public String load(String key) throws Exception {
                        return key+":empty";
                    }
                });
        cache.put("aa","11");
        System.out.println(cache.get("aa"));
        System.out.println(cache.get("bb"));
        //除了在build的时候设置没有key的调用方法外我们还能在调用的时候手动写
        String key ="cc";
        System.out.println(cache.get(key, new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (key == null){
                    return null;
                }
                return "empty1";
            }
        }));
        System.out.println(cache.get("cc"));
        System.out.println(cache.get("bb"));
        System.out.println(cache.get("newEmpty"));

        System.out.println(cache.getAll(Lists.newArrayList("aa","bb")));
        System.out.println(cache.asMap());

        //缓存回收
        //除了不能超过大小和设定的时间自动回收外还可以调用方法手动回收
        //个别清除
        cache.invalidate("aa");
        //批量清除
        cache.invalidateAll(Lists.newArrayList("cc","dd"));
        //清除所有缓存项
        cache.invalidateAll();
        //清理的时机：在写操作时顺带做少量的维护工作，或者偶尔在读操作时做——如果写操作实在太少的话
        //如果想自己维护则可以调用 Cache.cleanUp;
        cache.cleanUp();
        //另外有时候需要缓存中的数据做出变化重载一次,这个过程可以异步执行
        cache.refresh("aa");
        //还可以调用一下缓存的统计查看缓存的使用情况(需要在构建时开启)
        CacheStats cacheStats = cache.stats();
        //缓存命中率
        System.out.println(cacheStats.hitRate());
        //加载新值的平均时间，单位为纳秒
        System.out.println(cacheStats.averageLoadPenalty());
        //缓存项被回收的总数，不包括显式清除
        System.out.println(cacheStats.evictionCount());
    }
}

