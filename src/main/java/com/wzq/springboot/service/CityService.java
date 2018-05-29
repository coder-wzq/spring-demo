package com.wzq.springboot.service;

import com.wzq.springboot.bean.AuthService;
import com.wzq.springboot.domain.City;
import com.wzq.springboot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCity() {
        return cityRepository.findAll();
    }
}
