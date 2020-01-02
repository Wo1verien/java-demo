package com.logan.demo.javademo.guava.collections;

import com.google.common.collect.*;

import java.util.List;
import java.util.Set;

/**
 * Created 2019/12/31. 3:38 下午
 *
 * @author changzheng
 */
public class ImmutableCollections {

    public static void main(String[] args) {
        //of
        ImmutableSet<String> immutableSet = ImmutableSet.of("a", "b", "a", ",c");
        System.out.println(immutableSet);
        ImmutableMap<String, Integer> integerImmutableMap = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        System.out.println(integerImmutableMap);

        //copyOf
        List<String> list = Lists.newArrayList("a", "b");
        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        ImmutableSet<String> immutableSet1 = ImmutableSet.copyOf(list);
        ImmutableSet<Integer> immutableSet2 = ImmutableSet.copyOf(set);
        System.out.println(immutableSet2);

        //builder
        ImmutableList<String> immutableList =
                ImmutableList.<String>builder()
                        .add(String.valueOf(list))
                        .add("hello")
                        .addAll(list)
                        .add(String.valueOf(immutableSet1))
                        .build();
        System.out.println(immutableList);

    }

}
