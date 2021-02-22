package com.my.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by 86155 on 2020/8/30.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class paymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(paymentApplication.class,args);
    }
}
