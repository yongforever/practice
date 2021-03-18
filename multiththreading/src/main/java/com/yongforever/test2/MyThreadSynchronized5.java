package com.yongforever.test2;

/**
 * synchronized修饰静态方法
 */
public class MyThreadSynchronized5 {
    public static void main(String[] args) {

        MyThreadSynchronized5 obj = new MyThreadSynchronized5();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.test(); // 使用锁对象为obj
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.test2(); // 使用锁对象为obj
            }
        }).start();
    }

    public void test(){

        synchronized (MyThreadSynchronized5.class){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }

    }

    // 默认锁为运行时类及(MyThreadSynchronized5.class)
    public synchronized static void test2(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " ---> " + i);
        }
    }
}
