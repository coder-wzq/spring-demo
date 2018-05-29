package com.wzq.springboot.mapper;

import com.wzq.springboot.domain.User;
import com.wzq.springboot.mapper.selectProvider.UserSqlProvider;
import com.wzq.springboot.mapper.typeHandler.DateTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM tab_basic_users WHERE user_id = #{id}")
    @Results(id = "user", value = {@Result(column = "user_id", property = "userId"), @Result(column = "user_language", property = "userLanguage"), @Result(column = "create_time", property = "createTime", typeHandler = DateTypeHandler.class)})
    User getFirstUserInfo(@Param(value = "id") Integer id);

    @SelectProvider(type = UserSqlProvider.class, method = "getUserInfosList")
    @ResultMap(value = "user")
    List<User> getUserInfoList();

    User findByName(@Param(value = "name") String name);

    @Select("SELECT * FROM tab_basic_users WHERE loginname = #{name}")
    @ResultMap(value = "user")
    User findByLoginName(@Param(value = "name") String name);

    @Insert("insert into tab_basic_users (loginname,password,description,user_language,age) values (#{loginName},#{password},#{description},#{userLanguage},#{age})")
    Integer insertUser(User user);
}
