package com.yongforever.test2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class MyThreadAtomicReference {

    private static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet("abc","def");
                System.out.println(Thread.currentThread().getName() + "---" + atomicReference.get());
                atomicReference.compareAndSet("def","abc");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicReference.compareAndSet("abc","ghi");
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(atomicReference.get());
    }


}
