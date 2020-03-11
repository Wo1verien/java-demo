package com.logan.demo.javademo.lock.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Logan
 * @date 2020/3/11 11:15
 */
public class ReentrantLockTest {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    /**
     * 注意这个地方:lock被声明为成员变量
     */
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final ReentrantLockTest test = new ReentrantLockTest();

        new Thread("A") {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread("B") {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println("线程" + thread.getName() + "得到了锁...");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
            System.out.println("线程" + thread.getName() + "释放了锁...");
        }
    }
}

