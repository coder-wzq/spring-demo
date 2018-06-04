package com.wzq.springboot.domain;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String loginName;
    private String userLanguage;
    private Long createTime;
    @Max(value = 100, message = "最大年龄100")
    @Min(value = 18, message = "最小年龄18")
    private Integer age;
    @Length(min = 6, max = 10, message = "密码长度小于10位大于6位")
    private String password;
    private String description;

    public User() {
    }

    public User(String loginName, String password, String description, String userLanguage) {
        super();
        this.loginName = loginName;
        this.password = password;
        this.description = description;
        this.userLanguage = userLanguage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
