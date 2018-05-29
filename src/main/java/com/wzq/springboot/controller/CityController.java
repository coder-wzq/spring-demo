package com.wzq.springboot.controller;

import com.wzq.springboot.bean.AuthService;
import com.wzq.springboot.domain.City;
import com.wzq.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
@AuthService(value = { "admin","standard" })
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping(value = "/getAllCity",method = RequestMethod.GET)
    public List<City> getAllCity(){
        return cityService.getAllCity();
    }
}
