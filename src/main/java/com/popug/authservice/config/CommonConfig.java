package com.popug.authservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommonConfig {
    @Bean
    ModelMapper mapper() {
        return new ModelMapper();
    }
}
