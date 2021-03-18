package com.yongforever.test2;

/**
 * this锁对象
 */
public class MyThreadSynchronized {
    public static void main(String[] args) {

        MyThreadSynchronized obj = new MyThreadSynchronized();

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
    }

    public void test(){

        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }

    }
}
