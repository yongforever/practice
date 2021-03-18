package com.yongforever.test1;

public class MyThreadDaemon extends Thread {

    @Override
    public void run() {

        while (true){

            System.out.println("sub thread------ ");
        }
    }
}
