package com.wzq.springboot.mq;

import com.wzq.springboot.mq.fonout.FonoutMqSender;
import com.wzq.springboot.mq.topic.MqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMq {
    @Autowired
    private MqSender mqSender;

    @Autowired
    private FonoutMqSender fonoutMqSender;


    @Test
    public void topic() throws Exception {
        mqSender.send("hello");
        Thread.sleep(1000);
    }


    @Test
    public void fanout() throws Exception {
        fonoutMqSender.send();
        Thread.sleep(1000);
    }
}
