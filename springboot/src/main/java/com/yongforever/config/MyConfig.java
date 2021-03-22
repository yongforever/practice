package com.yongforever.config;

import com.yongforever.dao.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * proxyBeanMethods 默认为true,为true则说明该配置类使用了代理模式,为单例模式,会存在循环依赖问题
 * 设置为true后启动会较慢
 * 如果不存在依赖关系可以设置为false,为轻量级模式
 */
@Configuration(proxyBeanMethods = true)
//@Configuration
public class MyConfig {


    @Bean
    public User getUser(){
        return new User();
    }
}
