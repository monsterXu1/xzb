package com.my.histrixFeigne.controller;

import com.my.histrixFeigne.service.HsitrixFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import javafx.beans.DefaultProperty;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "defaultFallbackCommon")
public class HistrixFeignController {

    @Resource
    private HsitrixFeignService hsitrixFeignService;

    @GetMapping("/feign/get_histrix_ok")
    public String ok(){
       return hsitrixFeignService.get_histrix_ok();
    }



    @GetMapping("/feign/get_histrix_timeout")
    /*@HystrixCommand(fallbackMethod = "get_histrix_timeout_Header",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })*/
    @HystrixCommand //  不加参数时  会默认走 @DefaultProperties(defaultFallback = "defaultFallbackCommon")中的配置
    public String timeout(){
       return hsitrixFeignService.get_histrix_timeout();
    }


    public String get_histrix_timeout_Header(){
        return "我是消费方，我自己的请求只允许请求3S";
    }


    public String defaultFallbackCommon(){
        return "我是消费方，我自己的请求只timeout_Header_Common";
    }
}
