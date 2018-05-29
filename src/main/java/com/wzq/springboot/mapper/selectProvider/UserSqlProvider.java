package com.wzq.springboot.mapper.selectProvider;

public class UserSqlProvider {
    public String getUserInfosList(){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from tab_basic_users");
        return sql.toString();
    }
}
