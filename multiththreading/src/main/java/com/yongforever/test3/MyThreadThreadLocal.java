package com.yongforever.test3;

public class MyThreadThreadLocal {

    static ThreadLocal threadLocal = new ThreadLocal();

    static class MyThread extends  Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                threadLocal.set(Thread.currentThread().getName() + "---" + i);
                System.out.println(threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
