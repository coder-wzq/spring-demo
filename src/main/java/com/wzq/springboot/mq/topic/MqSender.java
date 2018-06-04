package com.wzq.springboot.mq.topic;

import com.wzq.springboot.config.TopicRabbitmqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String context = "msg --------- " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange", TopicRabbitmqConfig.wzq, context);
    }
}
