package com.wzq.springboot.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.wzq")
public class MqReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  1    : " + hello);
    }

}
