package com.my.rabbitMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RabbitMQApplicatiion15688 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplicatiion15688.class,args);
    }
}
