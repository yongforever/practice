package com.yongforever.test1;

public class MyThreadGetId extends Thread {

    @Override
    public void run() {

        System.out.println("run thread 线程名称:" + Thread.currentThread().getName() + ", 唯一标识 : " + Thread.currentThread().getId());
    }
}
