package com.wzq.springboot.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.hello")
public class MqReceiverAll {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  2    : " + hello);
    }

}
