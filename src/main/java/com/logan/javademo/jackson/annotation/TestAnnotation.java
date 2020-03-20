package com.logan.javademo.jackson.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created 2020/2/5. 2:48 下午
 *
 * @author changzheng
 */
public class TestAnnotation {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        MarketPO marketpo = new MarketPO();
        marketpo.setProvider("alert");
        marketpo.setAccessMode(AccessMode.DISCOVERY);
        marketpo.setManager(new Manager("logan",24));
        String json = objectMapper.writeValueAsString(marketpo);
        System.out.println(json);
    }
}
