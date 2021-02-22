package com.my.oeder.controller;

import com.my.common.entity.CommonResults;
import com.my.oeder.myRebbon.MyRebbon;
import com.netflix.loadbalancer.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.plugin.com.DispatchClient;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    private final  String  url_Payment = "http://my-payment-service";

    @Resource
    public RestTemplate restTemplate;
    @Resource
    private MyRebbon myRebbon;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/order/payment/getData")
    public CommonResults getData(@Param("id") String id){
       return restTemplate.getForObject(url_Payment+"/payment/getByid?id="+id,CommonResults.class);
    }
    @RequestMapping("/order/payment/getDataForEntity")
    public CommonResults getDataForEntity(@Param("id") String id){
        ResponseEntity<CommonResults> forEntity = restTemplate.getForEntity(url_Payment + "/payment/getByid?id=" + id, CommonResults.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            log.info("状态是："+forEntity.getStatusCode());
            return forEntity.getBody();
        }else {
            return new CommonResults(400,"errer");
        }
    }

    @GetMapping("/aa")
    public String a (){
        return "d";
    }

    @GetMapping("/order/getServiceInstance")
    public String  getServiceInstance(){

        List<ServiceInstance> instances = discoveryClient.getInstances("my-payment-service");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance myInstances = myRebbon.getMyInstances(instances);
        URI uri = myInstances.getUri();
        return restTemplate.getForObject(uri+"/payment/getPortMyself",String.class);
    }

}
