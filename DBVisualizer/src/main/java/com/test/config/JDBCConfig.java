package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class JDBCConfig {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        String driverPath = "";
        dataSourceBuilder.driverClassName(driverPath);
        String dbUrl = "";
        dataSourceBuilder.url(dbUrl);
        String dbUserName = "";
        dataSourceBuilder.username(dbUserName);
        String dbPassword = "";
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();
    }

    @Bean
    public SimpleJdbcInsert simpleJdbcInsert() {
        return new SimpleJdbcInsert(jdbcTemplate);
    }
}
