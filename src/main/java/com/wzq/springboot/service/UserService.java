package com.wzq.springboot.service;

import com.wzq.springboot.dao.HelloDao;
import com.wzq.springboot.domain.User;
import com.wzq.springboot.mapper.UserMapper;
import com.wzq.springboot.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private HelloDao helloDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    public Integer getUserCount(){
        return helloDao.getUserCount();
    }

    public User getFirstUserInfo(Integer id) {
        return userMapper.getFirstUserInfo(id);
    }

    public List<User> getUserInfoList() {
        return userMapper.getUserInfoList();
    }

    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    public User findByLoginName(String name) {
        if (redisUtil.hasKey(name)){
            logger.info((String)redisUtil.getValue(name));
        }else{
            logger.error("none currentUser");
        }
        User currentUser = userMapper.findByLoginName(name);
        redisUtil.putClass("currentUser",currentUser,100);
        return currentUser;
    }

    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
