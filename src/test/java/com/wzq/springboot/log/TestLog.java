package com.wzq.springboot.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLog {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testString() throws Exception {
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
    }
}
