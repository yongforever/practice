package com.yongforever.test1;

public class MyThreadYield extends Thread {

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("run 用时: " + (endTime - startTime));
    }
}
