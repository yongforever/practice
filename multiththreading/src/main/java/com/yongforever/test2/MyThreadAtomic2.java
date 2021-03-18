package com.yongforever.test2;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadAtomic2 {

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    myThread1.getCount();
//                }
//            }).start();
//        }
        for (int i = 0; i < 100; i++) {
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(MyThread1.count.get());
    }

    static class MyThread1 extends Thread{
        private  static  AtomicInteger count = new AtomicInteger();

        // 需要synchronized保证原子性
        public   static  void getCount(){
            for (int i = 0; i < 1000; i++) {
                count.getAndIncrement();
            }
            System.out.println(Thread.currentThread().getName() +"---"+ count.get());
        }

        @Override
        public void run() {

            getCount();
        }
    }
}
