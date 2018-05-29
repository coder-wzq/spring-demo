package com.wzq.springboot.demo_test.aop;

public class HelloWord {

    public void sayHello() {
        System.out.println("hello world !");
    }

    public static void main(String[] args) {
        HelloWord helloWord = new HelloWord();
        helloWord.sayHello();
    }
}
