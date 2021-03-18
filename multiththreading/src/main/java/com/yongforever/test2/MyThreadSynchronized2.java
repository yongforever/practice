package com.yongforever.test2;

/**
 * 锁对象不同不能实现同步
 * this锁对象
 */
public class MyThreadSynchronized2 {
    public static void main(String[] args) {

        MyThreadSynchronized2 obj1 = new MyThreadSynchronized2();
        MyThreadSynchronized2 obj2 = new MyThreadSynchronized2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj1.test(); // 使用锁对象为obj1
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.test(); // 使用锁对象为obj2
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
