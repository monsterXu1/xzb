package com.my.rabbitMQ.mqSender;

import com.my.rabbitMQ.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

@Component
public class MqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sender(){
        amqpTemplate.convertAndSend("spring-boot","spring-boot");
    }
    public void senderObject(){
        User user = new User();
        user.setAge("1");
        user.setName("xzb");
        amqpTemplate.convertAndSend("senderObject",user);
    }
    public void exchange(){
        amqpTemplate.convertAndSend("exchange","topic.messages","hello,rabbit~~~22");
        // amqpTemplate.convertAndSend("exchange","topic.message","hello,rabbit~~~11");
    }
    public void fanoutExchange(){
        amqpTemplate.convertAndSend("fanoutExchange","","xixi,haha");
    }
}
