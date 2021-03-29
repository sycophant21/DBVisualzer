package com.test.config;

import com.test.handler.QueryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SignUpConfig {

    @Bean
    public QueryHandler QueryHandler() {
        return new QueryHandler();
    }
}
