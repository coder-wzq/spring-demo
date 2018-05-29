package com.wzq.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {

    @Autowired
//    @Qualifier("wzq")
    JdbcTemplate jdbcTemplate;

    public Integer getUserCount() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from tab_basic_users", Integer.class);
        return count;
    }

}
