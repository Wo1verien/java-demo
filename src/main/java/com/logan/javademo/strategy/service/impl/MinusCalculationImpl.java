package com.logan.javademo.strategy.service.impl;

import com.logan.javademo.strategy.enums.OperatorEnums;
import com.logan.javademo.strategy.factory.OperatorFactory;
import com.logan.javademo.strategy.service.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created 2019/12/20. 10:43 上午
 *
 * @author changzheng
 */
@Service
@Slf4j
public class MinusCalculationImpl implements InitializingBean , OperatorService {
    @Override
    public int calculation(int a, int b) {
        log.info("minus操作请求参数：a={},b={}",a,b);
        return a - b;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        OperatorFactory.register(OperatorEnums.MINUS.getValue(),this);
    }
}
