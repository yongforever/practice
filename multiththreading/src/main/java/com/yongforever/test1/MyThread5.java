package com.yongforever.test1;

/**
 * currentThread的复杂案例
 */
public class MyThread5 extends Thread {

    public MyThread5() {

        System.out.println("构造方法中的线程名称:"+ Thread.currentThread().getName());
        System.out.println("构造方法中this线程名称:   "+ this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中的线程名称:"+ Thread.currentThread().getName());
        System.out.println("run方法中this线程名称:   "+ this.getName());
    }
}
