package com.my.histrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class HistrixServiceImpl implements Histrixservice {
    @Override
    public String histrix_ok(long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("--------ok-------------\"");
        return "----------------------"+id+"----------ok-------------";
    }

    @Override
    @HystrixCommand(fallbackMethod = "histrix_timeoutHeader",commandProperties = {
            //这个方法在执行3s 3s后算超时，会服务降级
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String histrix_timeout(long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程："+Thread.currentThread().getName()+"--------timeout-3S-------------\"");
        return "线程："+Thread.currentThread().getName()+"-----------timeout-----------"+id+"----------timeout-3S-------------";
    }
    public String histrix_timeoutHeader(long id) {
        log.info("线程："+Thread.currentThread().getName()+"--------histrix_timeoutHeader-------------\"");
        return "线程："+Thread.currentThread().getName()+"--------histrix_timeoutHeader-----------"+id+"---请稍后再试！--";
    }
}
