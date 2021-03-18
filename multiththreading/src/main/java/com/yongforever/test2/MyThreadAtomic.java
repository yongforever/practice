package com.yongforever.test2;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadAtomic {

    public static void main(String[] args) {
        MyInt myInt = new MyInt();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int y = 0; y < 10; y++) {
                        System.out.println(Thread.currentThread().getName()+": " + myInt.getNum());
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

//    static class MyInt {
//        int num;
//
//        public int getNum() {
//            return num++;
//        }
//    }
    static class MyInt {
        AtomicInteger num = new AtomicInteger();

        public int getNum() {
            return num.getAndIncrement();
        }
    }
}
