package com.logan.javademo.strategy.enums;

/**
 * Created 2019/12/20. 10:37 上午
 *
 * @author changzheng
 */
public enum OperatorEnums {

    /*
    加
     */
    ADD("+"),

    /*
    减
     */
    MINUS("-"),

    /*
    乘
     */
    MULTIPLY("*"),

    /*
    除
     */
    DIVIDE("/");

    private final String value;


    OperatorEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
