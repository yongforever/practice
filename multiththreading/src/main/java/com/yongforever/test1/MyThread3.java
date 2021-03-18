package com.yongforever.test1;

/**
 * 实现Runnable接口的方式创建线程
 * 当线程已经有父类了,可以使用Runnable的方式创建线程
 */
public class MyThread3 implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("sub thread " + i);
        }
    }
}
