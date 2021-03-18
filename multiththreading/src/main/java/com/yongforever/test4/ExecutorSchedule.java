package com.yongforever.test4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池执行固定任务
 */
public class ExecutorSchedule {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

//        // 延迟两秒钟执行
//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getId() + "---" + System.currentTimeMillis());
//            }
//        },2, TimeUnit.SECONDS);

        // 延迟两秒后每隔3秒执行一次
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(4000); // 如果任务执行时长超过设置间隔时间,则任务执行完都立即执行
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getId() + "---" + System.currentTimeMillis());
//            }
//        },2,3,TimeUnit.SECONDS);


        // 在上次任务执行完成后再间隔一段时间执行
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "---" + System.currentTimeMillis());
            }
        },3,2,TimeUnit.SECONDS);

    }
}
