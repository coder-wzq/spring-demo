package com.wzq.springboot.mapper;

import com.wzq.springboot.config.TargetDataSourceTwo;
import com.wzq.springboot.domain.City;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@TargetDataSourceTwo
public interface CityMapper {

    @Select("select * from tab_city")
    @Results(id = "city", value = {@Result(column = "city_id", property = "cityId"), @Result(column = "city_name", property = "cityName"), @Result(column = "province_name", property = "provinceName")})
    List<City> findAllCity();
}
