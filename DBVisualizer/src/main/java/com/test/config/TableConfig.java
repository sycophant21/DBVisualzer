package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TableConfig {

    @Bean
    public List<String> accessibleTables() {
        return new ArrayList<>();
    }

    @Bean
    public List<String> allTables() {
        return new ArrayList<>();
    }

    @Bean
    public String userId() {
        return "";
    }
}
