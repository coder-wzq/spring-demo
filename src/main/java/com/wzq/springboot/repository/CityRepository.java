package com.wzq.springboot.repository;

import com.wzq.springboot.domain.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City,Long> {

    List<City> findAll();
}
