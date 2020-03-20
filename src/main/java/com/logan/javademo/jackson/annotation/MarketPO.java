package com.logan.javademo.jackson.annotation;

import lombok.Data;

/**
 * Created 2020/2/5. 2:47 下午
 *
 * @author changzheng
 */
@Data
public class MarketPO {

    private String provider;

    private AccessMode accessMode;

    private Manager manager;
}
