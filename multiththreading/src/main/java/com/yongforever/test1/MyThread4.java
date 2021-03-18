package com.yongforever.test1;

/**
 * currentThread方法
 */
public class MyThread4 extends Thread {



    public MyThread4() {
        System.out.println("构造方法中打印线程名称:"+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中打印线程名称:" + Thread.currentThread().getName());
    }
}
