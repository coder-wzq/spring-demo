package com.wzq.springboot.service;

import com.wzq.springboot.domain.City;
import com.wzq.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public List<City> getAllCity() {
        return cityMapper.findAllCity();
    }
}
