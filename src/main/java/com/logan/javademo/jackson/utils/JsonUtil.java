package com.logan.javademo.jackson.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * Created 2019/12/20. 4:32 下午
 *
 * @author changzheng
 */
@Slf4j
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将对象转为string
     */
    public static <T> String obj2String(T obj) throws JsonProcessingException {

        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Parse Object to String error", e);
            throw e;
        }
    }

    /**
     * 将json转为java对象
     */
    public static <T> T string2Obj(String str, Class<T> clazz) throws JsonProcessingException {
        if(StringUtils.isEmpty(str) || clazz == null){
            return null;
        }

        try {
            return clazz.equals(String.class)? (T) str : objectMapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            log.warn("Parse String to Object error",e);
            throw e;
        }
    }

}
