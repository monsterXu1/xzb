package com.my.rabbitMQ.controller;

import com.my.rabbitMQ.mqCustmer.MqCustemer;
import com.my.rabbitMQ.mqSender.MqSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MqController {

    @Resource
    private MqSender mqSender;

    @GetMapping("/sender")
    public void sender (){
        mqSender.sender();
    }
    @GetMapping("/senderObject")
    public void senderObject (){
        mqSender.exchange();
    }
    @GetMapping("/exchange")
    public void exchange (){
        mqSender.exchange();
    }
    @GetMapping("/fanoutExchange")
    public void fanoutExchange (){
        mqSender.fanoutExchange();
    }
}
