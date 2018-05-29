package com.wzq.springboot.controller;

import com.wzq.springboot.bean.AuthService;
import com.wzq.springboot.domain.User;
import com.wzq.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${com.zx.name}")
    String author;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name) {
        return "hello " + name + "," + author;
    }

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    public Integer getUserCount() {
        return userService.getUserCount();
    }

    @RequestMapping(value = "/getFirstUserInfo", method = RequestMethod.GET)
    public User getFirstUserInfo(@RequestParam("id") Integer id) {
        return userService.getFirstUserInfo(id);
    }

    @AuthService(value = { "admin" })
    @RequestMapping(value = "/getUserInfoList", method = RequestMethod.GET)
    public List<User> getUserInfoList() {
        return userService.getUserInfoList();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public User findByName(@RequestParam("name") String name) {
        return userService.findByName(name);
    }

    @RequestMapping(value = "/findByLoginName/{name}", method = RequestMethod.GET)
    public User findByLoginName(@PathVariable("name") String name) {
        return userService.findByLoginName(name);
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Integer insertUser(@RequestBody @Valid User user) {
        return userService.insertUser(user);
    }

}
