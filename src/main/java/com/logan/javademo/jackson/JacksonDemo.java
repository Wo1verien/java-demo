package com.logan.javademo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created 2019/12/20. 11:40 上午
 *
 * @author changzheng
 */
@Slf4j
public class JacksonDemo {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Data
    static class User implements Serializable {
        private String name;
        private Integer age;
    }

    public static void main(String[] args) {

        try {
            // 对象转json字符串
            User user1 = new User();
            user1.setName("user1");
            user1.setAge(1);
            User user2 = new User();
            user2.setName("user2");
            user2.setAge(2);

            // 对象转json字符串
            String userJson = objectMapper.writeValueAsString(user1);
            log.info("user对象转json字符串：userJson={}", userJson);

            // Map转json字符串
            Map<String,User> map = Maps.newHashMap();
            map.put("user",user1);
            String mapJson = objectMapper.writeValueAsString(map);
            log.info("Map转json字符串：mapJson={}", mapJson);

            // List转json字符串
            List<User> list = Lists.newArrayList(user1,user2);
            String listJson = objectMapper.writeValueAsString(list);
            log.info("List转json字符串：listJson={}", listJson);

            // 数组转json字符串
            User [] users = {user1 , user2};
            String arrayJson = objectMapper.writeValueAsString(users);
            log.info("数组转json字符串：arrayJson={}", arrayJson);


            /* json字符串转对象*/
            String expected = "{\"name\":\"user1\",\"age\":1}";
            User user = objectMapper.readValue(expected,User.class);
            log.info("json字符串转对象:user={}",user);

            /* json字符串转Map*/
            String json2Map = "{\"user\":" +
                    "{\"name\":\"user1\",\"age\":1}" +
                    "}";
            Map<String,User> userMap = objectMapper.readValue(json2Map,Map.class);
            log.info("json字符串转Map:userMap={}",userMap);

            JavaType stringUserMap = objectMapper.getTypeFactory().constructParametricType(HashMap.class, String.class, User.class);
            Map<String,User> userMap1 = objectMapper.readValue(json2Map, stringUserMap);
            System.out.println(userMap1.get("user"));
            log.info("json字符串转Map:userMap1={}",userMap1);

            /* json字符串转List*/
            String json2List = "[" +
                    "{\"name\":\"user1\",\"age\":1}," +
                    "{\"name\":\"user2\",\"age\":2}" +
                    "]";
            List<User> userList = objectMapper.readValue(json2List,objectMapper.getTypeFactory().constructParametricType(ArrayList.class,User.class));
            log.info("json字符串转List:userList={}",userList);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
