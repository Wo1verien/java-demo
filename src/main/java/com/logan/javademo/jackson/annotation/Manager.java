package com.logan.javademo.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

/**
 * Created 2020/2/5. 2:51 下午
 *
 * @author changzheng
 */
@Data
public class Manager {

    @JsonValue
    private String name;

    private Integer age;

    public Manager(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
