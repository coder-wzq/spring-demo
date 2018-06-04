package com.wzq.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitmqConfig {

    public final static String wzq = "topic.wzq";
    public final static String hello = "topic.hello";

    //定义队列
    @Bean
    public Queue QueueOne() {
        return new Queue(wzq);
    }

    @Bean
    public Queue QueueTwo() {
        return new Queue(hello);
    }

    //交换机
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    //将队列和交换机绑定
    @Bean
    Binding bindingExchangeMessage(Queue QueueOne, TopicExchange exchange) {
        return BindingBuilder.bind(QueueOne).to(exchange).with(wzq);
    }

    @Bean
    Binding bindingExchangeMessages(Queue QueueTwo, TopicExchange exchange) {
        return BindingBuilder.bind(QueueTwo).to(exchange).with(wzq);
    }

}
