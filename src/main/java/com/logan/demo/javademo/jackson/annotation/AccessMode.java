package com.logan.demo.javademo.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created 2020/2/5. 2:44 下午
 *
 * @author changzheng
 */
public enum AccessMode {

    /**
     * 服务发现
     */
    DISCOVERY(0,"discovery"),

    /**
     * 域名
     */
    HOST(1, "host");


    private Integer code;


    private String desc;

    AccessMode(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }


    public Integer getCode() {
        return code;
    }

    /**
     * 注解@JsonValue注解:可以用在get方法或者属性字段上，一个类只能用一个，当加上@JsonValue注解时，该类的json化结果，只有这个get方法的返回值，而不是这个类的属性键值对.
     */
    @JsonValue
    public String getDesc() {
        return desc;
    }


    /**
     * 注解@JsonCreator
     * 当json在反序列化时，默认选择类的无参构造函数创建类对象，没有无参构造函数时会报错，@JsonCreator作用就是指定一个有参构造函数供反序列化时调用。该构造方法的参数前面需要加上@JsonProperty,否则会报错。
     */
    @JsonCreator
    public static AccessMode forValue(String desc){
        for(AccessMode a : values()){
            if(a.getDesc().equals(desc)){
                return a;
            }
        }
        return null;
    }

    public static AccessMode forCode(Integer code){
        for(AccessMode a : values()){
            if(a.getCode().equals(code)){
                return a;
            }
        }
        return null;
    }
}
