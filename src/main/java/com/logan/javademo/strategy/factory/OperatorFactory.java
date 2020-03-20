package com.logan.javademo.strategy.factory;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.logan.javademo.strategy.service.OperatorService;

import java.util.Map;

/**
 * Created 2019/12/20. 10:22 上午
 *
 * @author changzheng
 */
public class OperatorFactory {

    private static Map<String, OperatorService> services = Maps.newConcurrentMap();

    public static OperatorService getOperator (String operator){
        return services.get(operator);
    }

    public static void register (String operator , OperatorService operatorService){
        if (!Strings.isNullOrEmpty(operator)){
            services.put(operator,operatorService);
        }
    }
}
