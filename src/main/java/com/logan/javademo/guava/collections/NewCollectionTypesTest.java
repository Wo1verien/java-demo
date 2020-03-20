package com.logan.javademo.guava.collections;


import com.google.common.collect.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created 2019/12/31. 5:13 下午
 *
 * @author changzheng
 */
@Slf4j
@RunWith(SpringRunner.class)
public class NewCollectionTypesTest {

    @Test
    public void multisetTest(){
        //Multiset接口与MultiMap的系列集合：提供一个可以统计元素插入重复次数的无序集合
        Multiset<String> countMap = HashMultiset.create();
        //插入字符串"aa"2次
        countMap.add("aa",2);
        // [aa x 2]
        System.out.println(countMap);
        //给定元素固定次数
        countMap.setCount("aa",5);
        //删除1次
        countMap.remove("aa",1);
        countMap.add("b");
        countMap.add("b");
        System.out.println(countMap.count("aa"));
        System.out.println(countMap);
        System.out.println(countMap.elementSet());
        System.out.println(countMap.entrySet());
        //返回集合元素的总个数(重复的也记录 若想去重使用countMap.elementSet().size())
        System.out.println(countMap.size());
    }

    @Test
    public void multimapTest(){
        //Multimap系列接口集合 和Multiset很相似 可以理解成Multiset的map版本 对应的实现将上面的对应map改为Multimap
        //Multimap主要是为了一个键映射到多个值。换句话说，Multimap是把键映射到任意多个值的一般方式。
        //Map<Integer,Set<String>>
        Multimap<Integer,String> multimap = HashMultimap.create();
        multimap.put(1,"a");
        multimap.put(1,"a");
        multimap.putAll(2, Lists.newArrayList("a","b","a","c"));
        //移除键到值的映射；如果有这样的键值并成功移除，返回true。
        multimap.remove(2, "b");
        System.out.println(multimap);
        //移除一个key所有的映射值
        multimap.removeAll(1);
        //替换原有的映射值集合
        multimap.replaceValues(2, Lists.newArrayList("a", "b", "c", "d"));
    }

    @Test
    public void biMapTest(){
        //BiMap系列接口集合：为了解决实现键值对的双向映射需要维护两个单独的map的问题
        //其对应的实现HashBiMap，ImmutableBiMap，EnumBiMap，EnumHashBiMap
        BiMap<Integer,String> biMap = HashBiMap.create();
        biMap.put(1,"value");
        System.out.println(biMap.get(1));
        System.out.println(biMap.inverse().get("value"));
    }

    @Test
    public void tableTest(){
        //Table<R,C,V> == Map<R,Map<C,V>>
        Table<String,String,String> stringStringStringTable = HashBasedTable.create();
        stringStringStringTable.put("row","column","value");
        stringStringStringTable.put("a","b","v");
        System.out.println(stringStringStringTable.row("a"));
        System.out.println(stringStringStringTable.cellSet());
        System.out.println(stringStringStringTable.rowKeySet());
    }
}
