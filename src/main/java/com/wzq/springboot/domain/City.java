package com.wzq.springboot.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tab_city")
public class City {
    @Id
    @GeneratedValue
    private Integer cityId;

    @Column
    private String cityName;
    @Column
    private String provinceName;
    @Transient //不进行映射
    private Timestamp createTime;


    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
