package com.yongforever;

import com.yongforever.test1.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyThreadTest {

    /**
     * MyThread测试
     */
    @Test
    public void myThreadTest(){

        /**
         * 创建线程实例
         */
        MyThread thread = new MyThread();

        /**
         * 开启线程
         */
        thread.start();

        System.out.println("子线程之后执行--------");
    }

    /**
     * Mythread2测试
     */
    @Test
    public void Mythread2(){

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main thread ------ " + i);
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * MyThread3测试
     */
    @Test
    public void MyThread3(){
        MyThread3 myThread3 = new MyThread3();
        Thread thread = new Thread(myThread3);
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main thread--->" + i);
        }

        // 匿名内部类的方式
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("main thread------>" + i);
                }
            }
        });
        thread3.start();
    }

    /**
     * MyThread4方法测试
     */
    @Test
    public void myThread4(){
        MyThread4 myThread4 = new MyThread4();
        myThread4.start();
    }

    /**
     * MyThread5方法测试
     */
    @Test
    public void myThread5(){
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("myThread5");
        myThread5.start();

        Thread thread = new Thread(myThread5);
        thread.start();
    }

    /**
     * MyThread6方法测试
     */
    @Test
    public void myThread6(){
        MyThread6 myThread6 = new MyThread6();
        System.out.println("begin == " + myThread6.isAlive());

        myThread6.start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 是否存活取决于线程是否执行完,可能为ture,可能为false
        System.out.println("end == " + myThread6.isAlive());
    }

    /**
     * MyThread7方法测试
     */
    @Test
    public void myThread7(){
        MyThread7 myThread7 = new MyThread7();
        System.out.println("main,begin == " + System.currentTimeMillis());
        myThread7.start();
        //Thread.sleep(2000);
        System.out.println("main,end == " + System.currentTimeMillis());
    }

    /**
     * myThreadGetId
     */
    @Test
    public void myThreadGetId(){

        System.out.println("run thread 线程名称:" + Thread.currentThread().getName() + ", 唯一标识 : " + Thread.currentThread().getId());

        for(int i = 0 ; i < 10 ; i++){
            MyThreadGetId myThreadGetId = new MyThreadGetId();
            myThreadGetId.start();
        }

    }

    /**
     * myThreadYield
     */
    @Test
    public void myThreadYield(){

        new MyThreadYield().start();

        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
            Thread.yield();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("main 用时: " + (endTime - startTime));

    }

    /**
     * myThreadSetPriority
     */
    @Test
    public void myThreadSetPriority(){

        MyThreadSetPriority threadA = new MyThreadSetPriority();
        threadA.start();
        MyThreadYield threadB = new MyThreadYield();
        threadB.start();
    }

    /**
     * myThreadInterrupted
     */
    @Test
    public void myThreadInterrupted(){

        MyThreadInterrupted thread = new MyThreadInterrupted();
        thread.start();

        for (int i = 0; i < 100; i++) {

            System.out.println("main thread --->" + i);

        }
        thread.interrupt();
    }

    /**
     * myThreadDaemon
     */
    @Test
    public void myThreadDaemon(){

        MyThreadDaemon thread = new MyThreadDaemon();
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main thread------");
        }
    }


}
