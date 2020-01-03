package com.logan.demo.javademo.guava.collections;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created 2020/1/2. 5:39 下午
 *
 * @author changzheng
 */
public class CollectionsUtils {

    public static void main(String[] args) {
        //Lists
        List<Integer> integerList = Ints.asList(1,2,3,4,5);
        List<String> stringList = Lists.newArrayList("alpha","beta","gamma");
        //反转list
        System.out.println(Lists.reverse(integerList));
        //指定大小分隔
        System.out.println(Lists.partition(stringList,2));

        //Sets
        Set<String> stringSet = Sets.newHashSet("one", "two", "three", "six", "seven", "eight");
        Set<String> stringSet1 = ImmutableSet.of("two", "three", "five", "seven");
        //联合两个set
        System.out.println(Sets.union(stringSet1,stringSet));
        //求交集
        System.out.println(Sets.intersection(stringSet,stringSet1));
        //diff(参数1有的参数2没有的)
        System.out.println(Sets.difference(stringSet1,stringSet));
        System.out.println(Sets.symmetricDifference(stringSet,stringSet1));

        //Maps
        Map<String,Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 4);
        //Maps.difference(Map, Map)用来比较两个Map以获取所有不同点。该方法返回MapDifference对象，把不同点的维恩图分解
        MapDifference<String,Integer> diff = Maps.difference(left,right);
        //是否相同
        System.out.println(diff.areEqual());
        //找到键相等值不想等的
        System.out.println(diff.entriesDiffering());
        //找到键值对都相等的
        System.out.println(diff.entriesInCommon());
        //找到只存在于左边的
        diff.entriesOnlyOnLeft(); // {"a" = 1}
        //找到只存在于右边的
        diff.entriesOnlyOnRight(); // {"d" = 5}

        //Iterables工具类连接两个Iterable（集合）
        // concatenated包括元素 1, 2, 3, 4, 5, 6
        Iterable<Integer> concatenated = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6));
        System.out.println(concatenated);
    }
}
