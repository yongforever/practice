package com.yongforever.test2;

import jdk.nashorn.internal.ir.IfNode;
import org.mockito.internal.matchers.Equals;

/**
 * 在多线程中可能需要多个锁,如果获取锁的顺序不一致可能导致死锁
 */
public class MyThreadDeathLock {

    public static void main(String[] args) {

        myThread myThread1 = new myThread();
        myThread1.setName("a");
        myThread1.start();

        myThread myThread2 = new myThread();
        myThread2.setName("b");
        myThread2.start();
    }

    static class myThread extends Thread{
        public static final  Object lock1 = new Object();
        public static final  Object lock2 = new Object();

        @Override
        public void run() {

            if ("a".equals(Thread.currentThread().getName())){
                synchronized (lock1){
                    System.out.println("获取lock1锁,做一些事情");
                    synchronized (lock2){
                        System.out.println("获取lock2锁,做其它事情");
                    }
                }
            }

            if ("b".equals(Thread.currentThread().getName())){
                synchronized (lock2){
                    System.out.println("获取lock2锁,做一些事情");
                    synchronized (lock1){
                        System.out.println("获取lock1锁,做其它事情");
                    }
                }
            }
        }
    }
}
