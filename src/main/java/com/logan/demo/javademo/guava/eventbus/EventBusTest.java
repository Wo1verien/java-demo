package com.logan.demo.javademo.guava.eventbus;

import com.google.common.eventbus.EventBus;

import javax.swing.event.ChangeEvent;

/**
 * Created 2020/1/7. 7:03 下午
 *
 * @author changzheng
 */
public class EventBusTest {
    public static void main(String[] args) {
        //在程序的某处创建事件总线并注册事件
        EventBus eventBus=new EventBus();
        eventBus.register(new EventBusChangeRecorder());
        // 在之后的程序中 提交发生的事件
        ChangeEvent event=new ChangeEvent(new EventBusChangeRecorder());
        eventBus.post(event);
        //需要异步执行可以使用EventBus的子类AsyncEventBus
    }
}
