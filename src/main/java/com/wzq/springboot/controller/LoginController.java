package com.wzq.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("name");
        if (StringUtils.isEmpty(userName)){
            return "login";
        }else{
            return "index";
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, String userName, String password){
        request.getSession().setAttribute("name",userName);
        return "index";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String doLogout(HttpServletRequest request, String userName, String password){
        request.getSession().setAttribute("name","");
        return "login";
    }

}
