package com.wzq.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.wzq.springboot.mapper", annotationClass = TargetDataSourceOne.class, sqlSessionFactoryRef = "oneSqlSessionFactory")
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "oneDB")
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.druid.wzq.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.druid.wzq.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.druid.wzq.password"));
        return dataSource;
    }

    @Bean(name = "oneSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("oneDB") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "oneTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("oneDB") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "oneSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "wzq")
    public JdbcTemplate oneJdbcTemplate(@Qualifier("oneDB") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
