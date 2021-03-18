package com.yongforever.test2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用Atomic定义一个全局的计数器
 * 单例模式
 */
public class Indicator {
    // 静态方法私有化
    private Indicator(){};
    // 定义一个私有的本类静态对象
    private static final Indicator indicator = new Indicator();
    // 提供一个对外访问对象的静态方法
    public static Indicator getIndicator(){
        return indicator;
    }

    // 使用原子类保证原子性
    private static AtomicLong requestCount = new AtomicLong(0); // 记录请求总数
    private static AtomicLong successCount = new AtomicLong(0); // 记录成功总数
    private static AtomicLong failureCount = new AtomicLong(0); // 记录失败总数

    // 新增请求
    public void newRequestReceive(){
        requestCount.getAndIncrement();
    }

    // 处理成功
    public void requestSuccess(){
        successCount.getAndIncrement();
    }

    // 处理失败
    public void requestFailure(){
        failureCount.getAndIncrement();
    }

    // 获取请求总数,成功,失败数
    public long getRequestCount(){
        return requestCount.get();
    }

    public long getRequestSuccess(){
        return successCount.get();
    }

    public long getFailureRequest(){
        return failureCount.get();
    }
}
