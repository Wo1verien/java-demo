package com.logan.javademo.thread;

import lombok.AllArgsConstructor;

/**
 * Created 2020/1/8. 10:24 上午
 * 继承Thread类，重写该类的run()方法。
 * @author changzheng
 */
@AllArgsConstructor
public class MyThread extends Thread {

    private String name;

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行  ：" + i);
        }
    }
}
