package com.yongforever.test1;

import javax.security.auth.Subject;

public class MyThreadInterrupted extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {

            if (this.isInterrupted()){
                System.out.println("中断子线程");
                break;
            }
            System.out.println("sub thread --->" + i);
        }
    }
}
