package com.wzq.springboot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.wzq.springboot.mapper", annotationClass = TargetDataSourceTwo.class, sqlSessionFactoryRef = "twoSqlSessionFactory")
public class TwoDateSourceConfig {

    @Bean(name = "twoDB")
    @ConfigurationProperties("spring.datasource.druid.wzq1")
    public DataSource dataSourcewzq1(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("twoDB") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "twoTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("twoDB") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "twoSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "wzq1")
    public JdbcTemplate oneJdbcTemplate(@Qualifier("twoDB") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
