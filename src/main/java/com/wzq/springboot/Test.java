package com.wzq.springboot;

import org.springframework.data.redis.core.SetOperations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    //继承Thread类并重写run方法
    public static class MyThread extends Thread {

        @Override
        public void run() {

            System.out.println("I am a child thread");

        }
    }

    public static void main(String[] args) {
//        // 创建线程
//        MyThread thread = new MyThread();
//        // 启动线程
//        thread.start();
        Set<String> s = new HashSet<>();
        s.add("1");
        s.add("2");
        s.add("1");
        s.forEach((value)-> System.out.println(value));

        List<String> ls = new ArrayList<>();
        ls.add("11");
        ls.add("22");
        ls.add("11");
        ls.forEach((value)-> System.out.println(value));

    }
}
