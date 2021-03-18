package com.yongforever.test2;

/**
 * 使用synchronized同步方法实例
 */
public class MyThreadSynchronized4 {
    public static void main(String[] args) {

        MyThreadSynchronized4 obj1 = new MyThreadSynchronized4();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj1.test(); // 使用锁对象为obj1
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new MyThreadSynchronized4().test2(); // 使用锁对象为obj1
            }
        }).start();
    }

    public void test(){
        synchronized (this){ // 锁对象为this
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }

    }

    // 默认锁对象是this
    public synchronized void test2(){

        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " ---> " + i);
            }
        }

    }
}
