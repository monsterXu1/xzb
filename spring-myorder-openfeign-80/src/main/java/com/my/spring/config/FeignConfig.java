package com.my.spring.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level getLoggerLevel(){
       /* return Logger.Level.NONE;  //默认不存在日志
        return Logger.Level.BASIC;   // 记录请求方法、URL 响应状态、执行时间
        return Logger.Level.HEADERS;  //除了BASIC中的信息外，还有请求和相应的头信息*/
        return Logger.Level.FULL;   //除了HEADER中的信息外，还有请求相应正文及元素

    }
}
