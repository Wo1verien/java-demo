package com.logan.demo.javademo.guava.eventbus;

import com.google.common.eventbus.Subscribe;

import javax.swing.event.ChangeEvent;

/**
 * Created 2020/1/7. 7:01 下午
 *
 * @author changzheng
 */
@SuppressWarnings("UnstableApiUsage")
public class EventBusChangeRecorder {
    @Subscribe
    public void recordCustomerChange(ChangeEvent e) {
        System.out.println("触发事件");
    }
}
