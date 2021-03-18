package com.yongforever.test1;

public class MyThread2 extends Thread {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread "+ i);
                int time = (int) (Math.random()*1000);
                Thread.sleep(time); // 线程休眠
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
