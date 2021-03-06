package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.example.demo")
public class MyConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}