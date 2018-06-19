package com.wzq.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private int count=0;

//    @Scheduled(fixedRate =6000)
//    private void printLog(){
//        System.out.println("LOG  "+(count++));
//    }
//
//    @Scheduled(fixedRate =12000)
//    private void printError(){
//        System.out.println("Error  "+(count++));
//    }
}
