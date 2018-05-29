package com.wzq.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {
    private Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping(value = "/testLog", method = RequestMethod.GET)
    public String testLogger() {
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        return "testLog";
    }
}
