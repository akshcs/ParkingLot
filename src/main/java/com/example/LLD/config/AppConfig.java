package com.example.LLD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public String myString() {
        return "Hello, world!";
    }

    @Bean
    public long myLong() {
        return 0L;
    }
}
