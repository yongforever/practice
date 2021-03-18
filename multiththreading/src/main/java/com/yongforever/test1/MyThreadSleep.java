package com.yongforever.test1;

/**
 * sleep方法实现一个简单计时器
 */
public class MyThreadSleep {

    public static void main(String[] args) {

//        int timer = 10;
//
//        if (args.length > 0){
//            timer = Integer.parseInt(args[0]);
//        }
//
//        while (true){
//
//            System.out.println("倒计时:" + timer);
//            timer--;
//            if (timer < 0){
//                break;
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        myThreadSetPriority();
    }

    public static void myThreadSetPriority(){

        MyThreadSetPriority threadA = new MyThreadSetPriority();
        threadA.setPriority(1);
        threadA.start();
        MyThreadYield threadB = new MyThreadYield();
        threadB.setPriority(10);
        threadB.start();
    }
}
