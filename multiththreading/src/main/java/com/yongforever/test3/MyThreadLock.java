package com.yongforever.test3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁在不同方法上面的使用
 */
public class MyThreadLock {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                test1();
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                test2();
            }
        };

        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t2).start();
        new Thread(t2).start();


    }

    public static void test1(){

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " ---test1---获得锁" );
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " ---test1---释放锁" );

        }

    }

    public static void test2(){

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " ---test2---获得锁" );
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " ---test2---释放锁" );

        }

    }

}
