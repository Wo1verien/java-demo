package com.logan.javademo.thread;

import lombok.AllArgsConstructor;

/**
 * Created 2020/1/8. 10:28 上午
 * 实现java.lang.Runnable接口
 * 具体做法：实现Runnable接口，并重写该接口的run()方法，该run()方法同样是线程执行体，创建Runnable实现类的实例，并以此实例作为Thread类的target来创建Thread对象，该Thread对象才是真正的线程对象。
 * @author changzheng
 */
@AllArgsConstructor
public class MyRunnable implements Runnable{

    private String name;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行  ：" + i);
        }
    }
}
