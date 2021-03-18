package com.yongforever.test2;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyThreadAtomicIntergerArray {

    private static AtomicIntegerArray array = new AtomicIntegerArray(10);

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new myThread();
        }

        for (Thread thread : threads) {
            thread.start();
        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 主线程需要等所有子线程执行完成才能进行打印
        // 把所有子线程合并到主线程
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(array);
    }

    static class myThread extends Thread{

        @Override
        public void run() {

            for (int i = 0; i < 1000; i++) {
                for (int y = 0; y < 10; y++) {
                    array.getAndIncrement(y % array.length());
                }
            }

        }
    }
}
