package com.test.config;

import com.test.db.QueryBuilder;
import com.test.db.SQLHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryHandlerConfig {

    @Bean
    public SQLHandler sqlHandler() {
        return new SQLHandler();
    }

    @Bean
    public QueryBuilder queryBuilder() {
        return new QueryBuilder("", "", "", "", "", "");
    }
}
