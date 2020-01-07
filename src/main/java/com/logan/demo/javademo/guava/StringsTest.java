package com.logan.demo.javademo.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created 2020/1/7. 5:08 下午
 *
 * @author changzheng
 */
@SuppressWarnings("UnstableApiUsage")
@Slf4j
@RunWith(SpringRunner.class)
public class StringsTest {

    @Test
    public void stringsJoinerTest() {
        //字符串拼接-连接器Joiner
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));

        List<String> names = Lists.newArrayList("John", null, "Jane", "Adam", "Tom");
        String name = Joiner.on(",")
                //跳过null
                .skipNulls()
                //.useForNull("nameless")将null换为nameless
                .join(names);
        log.info(name);
        Map<String, Integer> salary = Maps.newHashMap();
        salary.put("John", 1000);
        salary.put("Jane", 1500);
        String result = Joiner.on(",")
                //key-value的拼接字符
                .withKeyValueSeparator(":::")
                .join(salary);
        log.info(result);
    }

    @Test
    public void stringSplitterTest() {
        //字符串拆分--拆分器Splitter
        List<String> list = Splitter.on(";")
                //去除前后空格
//                .trimResults()
                //去除前后指定字符
//                .trimResults(CharMatcher.is('*'))
                .trimResults(CharMatcher.anyOf("* "))
                //去除空值
                .omitEmptyStrings()
                //限制拆分字符的长度
                .limit(3)
                .splitToList("one* ; two ;; three;four*;*five");
        System.out.println(list);
        Iterable<String> iterable = Splitter.on(",").split("a,b,c");
        iterable.forEach(System.out::println);
        Map<String, String> map = Splitter.on("#").withKeyValueSeparator("=").split("Java=1#C++=2#C=3#Shell=4");
        System.out.println(map);
    }
}
