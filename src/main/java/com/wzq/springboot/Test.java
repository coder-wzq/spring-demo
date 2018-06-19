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

    public class User {
        private String userName;
        private Integer age;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    public User userOne(){
        User user = new User();
        user.setUserName("wzq");
        return user;
    }

    public User changeUser(User userOne){
        userOne.setAge(29);
        return userOne;
    }


    public static void main(String[] args) {
//        // 创建线程
//        MyThread thread = new MyThread();
//        // 启动线程
//        thread.start();


//        Set<String> s = new HashSet<>();
//        s.add("1");
//        s.add("2");
//        s.add("1");
//        s.forEach((value)-> System.out.println(value));
//
//        List<String> ls = new ArrayList<>();
//        ls.add("11");
//        ls.add("22");
//        ls.add("11");
//        ls.forEach((value)-> System.out.println(value));

//        User u = changeUser();
    }
}
