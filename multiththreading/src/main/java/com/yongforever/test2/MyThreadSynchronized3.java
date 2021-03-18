package com.yongforever.test2;

/**
 * 使用常量作为锁对象
 */
public class MyThreadSynchronized3 {
    public static void main(String[] args) {

        MyThreadSynchronized3 obj = new MyThreadSynchronized3();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.test(); // 使用锁对象为obj
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.test(); // 使用锁对象为obj
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2(); // 使用锁对象为obj
            }
        }).start();
    }

    public static final Object obj = new Object();

    public void test(){

        synchronized (obj){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }

    }

    public static void test2(){

        synchronized (obj){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }

    }
}
