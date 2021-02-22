package com.my.spring.controller;

import com.my.common.entity.CommonResults;
import com.my.common.entity.PaymentEntity;
import com.my.spring.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by 86155 on 2020/8/30.
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/ss")
    public String  ssa(){
        return "dd";
    }


    @PostMapping(value = "/payment/creat")
    public CommonResults creat( @RequestBody PaymentEntity paymentEntity){
        int creat = paymentService.creat(paymentEntity);

        log.info("--------插入成功,{}条-------",creat);

        if(creat>0){
            return new CommonResults(200,"插入成功"+port,creat);
        }else{
            return new  CommonResults(400,"插入失败",null);
        }
    }
    @RequestMapping("/payment/getByid")
    public CommonResults getByid(@Param(value = "id") Long id ){
        PaymentEntity paymentEntity = paymentService.getById(id);
        log.info("--------查询成功,{}条-------",1);

        if(paymentEntity!=null){
            return new  CommonResults(200,"查询111成功 端口："+port,paymentEntity);
        }else{
            return new  CommonResults(400,"无数据；端口："+port,null);
        }
    }
    @RequestMapping("/payment/getByid/{id}")
    public CommonResults getByid1(@PathVariable(value = "id") Long id ){
        PaymentEntity paymentEntity = paymentService.getById(id);
        log.info("--------查询成功,{}条-------",1);

        if(paymentEntity!=null){
            return new  CommonResults(200,"查询222成功 端口："+port,paymentEntity);
        }else{
            return new  CommonResults(400,"无数据；端口："+port,null);
        }
    }

    @RequestMapping("/payment/getPortMyself")
    public String getPortMyself(){
        return port;
    }

    @RequestMapping("/payment/getPortMyselfTimeOut")
    public String getPortTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
