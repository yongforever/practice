package com.yongforever.test1;

/**
 * sleep方法
 */

public class MyThread7 extends Thread {

    @Override
    public void run() {


        try {
            System.out.println("run方法线程名称: " + Thread.currentThread().getName() + ",begin == " + System.currentTimeMillis());
            Thread.sleep(20);
            System.out.println("run方法线程名称: " + Thread.currentThread().getName() + ",end == " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
