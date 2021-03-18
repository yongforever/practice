package com.yongforever.test2;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadVolatile {

    public static void main(String[] args) {

        myThread myThread = new myThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.printString();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("修改flag值");
        myThread.setFlag(false);



    }

    static class myThread{
        private volatile boolean flag = true;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void printString(){
            System.out.println(Thread.currentThread().getName() + "-开始");
            while (flag){

            }
            System.out.println(Thread.currentThread().getName() + "-结束");
        }
    }


}
