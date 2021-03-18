package com.yongforever.test1;

/**
 * junit单元测试主线程执行完sleep后代码不执行,
 */
public class MyThread7Main {

    public static void main(String[] args) {
        MyThread7 myThread7 = new MyThread7();
        System.out.println("main,begin == " + System.currentTimeMillis());
        myThread7.start();
        //Thread.sleep(2000);
        System.out.println("main,end == " + System.currentTimeMillis());
    }
}
