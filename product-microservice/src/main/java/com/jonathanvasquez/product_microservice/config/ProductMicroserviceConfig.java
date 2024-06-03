package com.jonathanvasquez.product_microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductMicroserviceConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
