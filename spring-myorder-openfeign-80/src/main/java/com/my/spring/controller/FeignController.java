package com.my.spring.controller;

import com.my.common.entity.CommonResults;
import com.my.common.entity.PaymentEntity;
import com.my.spring.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignController {
    @Resource
    private FeignService feignService;

    @RequestMapping("/feign/payment/getByid")
    public CommonResults<PaymentEntity> getByid(@Param(value = "id") Long id ){

        CommonResults<PaymentEntity> byid = feignService.getByid(id);
        return byid;
    }

    @RequestMapping("/feign/payment/getPortMyselfTimeOut")
    public String getBytimeout(){
        //openFeign客户端默认是只能请求1s，超过则报错  ，
        // 由于openFeign底层有的是ribbon，所以只要设置ribbon的超时时间即可

        return feignService.getPortTimeOut();
    }

}
