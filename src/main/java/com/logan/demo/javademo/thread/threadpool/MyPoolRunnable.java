package com.logan.demo.javademo.thread.threadpool;

import java.util.Date;

/**
 * @author Logan
 * @date 2020/3/11 16:36
 */
public class MyPoolRunnable implements Runnable {
    private String command;

    public MyPoolRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
