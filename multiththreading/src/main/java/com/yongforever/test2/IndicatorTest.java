package com.yongforever.test2;

import java.util.Random;

/**
 * 模拟用户请求
 */
public class IndicatorTest {

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 新增请求
                    Indicator.getIndicator().newRequestReceive();

                    int num = new Random().nextInt();
                    if (num % 2 == 0){
                        // 处理成功
                        Indicator.getIndicator().requestSuccess();
                    }else {
                        Indicator.getIndicator().requestFailure();
                    }
                }
            }).start();

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印请求数
        System.out.println(Indicator.getIndicator().getRequestCount());
        System.out.println(Indicator.getIndicator().getRequestSuccess());
        System.out.println(Indicator.getIndicator().getFailureRequest());
    }
}