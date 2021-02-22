package com.my.iRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfIRuleConfig {

    @Bean
    public IRule myRule(){
        return new RandomRule() ; //随机
       // return new RetryRule();  //按照轮询获取文件列表，如果失败，则重试重新获取
        //return new BestAvailableRule(); // 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发最小的服务。

    }
}
