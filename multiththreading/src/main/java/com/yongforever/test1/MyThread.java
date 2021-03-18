package com.yongforever.test1;

/**
 * 1.继承Thread类
 */
public class MyThread extends Thread {

    /**
     * 2.重写run方法
     */
    @Override
    public void run() {
        System.out.println("这是子线程-----");
    }
}

