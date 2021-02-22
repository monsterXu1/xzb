package com.my.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ElasticSeatrchApplication8088 {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSeatrchApplication8088.class,args);
    }
}
