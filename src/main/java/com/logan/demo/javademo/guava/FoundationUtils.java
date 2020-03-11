package com.logan.demo.javademo.guava;

import com.google.common.primitives.Ints;

import java.util.List;

import static com.google.common.base.Preconditions.*;

/**
 * Created 2019/12/23. 10:47 上午
 *
 * @author changzheng
 */
public class FoundationUtils {

    public static void main(String[] args) {

        int i = 1;
        String a = "";
        int[] j = {4, 1, 2, 3};
        List<Integer> l = Ints.asList(j);

        //前置检查方法
        //条件检查 不通过抛出IllegalArgumentException及自定义描述 自定义描述支持类似于String.format()的字符串拼接但是只能用%s
        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
        //空值检查 不通过抛出NullPointerException及自定义描述
        checkNotNull(a, "Argument was null");
        //状态检查 不通过抛出IllegalStateException及自定义描述
        checkState(i >= 0, "Argument was %s but expected nonnegative", i);
        //检查列表、字符串或数组某一索引是否有效 不通过抛出IndexOutOfBoundsException
        checkElementIndex(2, l.size());
        //检查列表、字符串或数组某一位置是否有效 不通过抛出IndexOutOfBoundsException
        checkPositionIndex(2, l.size());
        //检查列表、字符串或数组某一范围是否有效 不通过抛出IndexOutOfBoundsException
        checkPositionIndexes(1, 2, l.size());

    }
}
