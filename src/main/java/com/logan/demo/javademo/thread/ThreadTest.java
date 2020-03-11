package com.logan.demo.javademo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Logan
 * @date 2020/3/11 14:56
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread myThread1 = new MyThread("A");
        Thread myThread2 = new MyThread("B");
        myThread1.start();
        myThread2.start();
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 创建一个Runnable实现类的对象
        Runnable myRunnable = new MyRunnable("A1");
        // 将myRunnable作为Thread target创建新的线程
        Thread thread1 = new Thread(myRunnable);
        Runnable myRunnable1 = new MyRunnable("B1");
        Thread thread2 = new Thread(myRunnable1);
        // 调用start()方法使得线程进入就绪状态
        thread1.start();
        thread2.start();


        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            //取得新创建的线程中的call()方法返回的结果
            int sum = futureTask.get();
            System.out.println("task运行结果,sum = " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}
