package com.my.spring.service;

import com.my.common.entity.CommonResults;
import com.my.common.entity.PaymentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "my-payment-service")
public interface FeignService {
    @RequestMapping("/payment/getByid/{id}")
    public CommonResults<PaymentEntity> getByid(@PathVariable(value = "id") Long id );

    @RequestMapping("/payment/getPortMyselfTimeOut")
    public String getPortTimeOut();
}
