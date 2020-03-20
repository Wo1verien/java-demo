package com.logan.javademo.strategy;

import com.logan.javademo.strategy.factory.OperatorFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created 2019/12/20. 10:14 上午
 *
 * @author changzheng
 */
@RestController
public class StrategyController {

    @GetMapping("/strategyTest")
    public int strategyTest(@RequestParam(value = "a")Integer a , @RequestParam(value = "b")Integer b ,@RequestParam(value = "operation") String operation){
        return OperatorFactory.getOperator(operation).calculation(a,b);
    }
}
