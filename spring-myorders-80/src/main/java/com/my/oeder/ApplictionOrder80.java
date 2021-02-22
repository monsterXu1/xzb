package com.my.oeder;

import com.my.iRule.MySelfIRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
//ribbon 自定义规则，当访问my-payment-service服务时，启用自定义的规则，默认轮询
@RibbonClient(name = "my-payment-service",configuration = MySelfIRuleConfig.class)
public class ApplictionOrder80 {


    public static void main(String[] args) {
        SpringApplication.run(ApplictionOrder80.class,args);
    }
}
