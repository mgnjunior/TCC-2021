package com.consultorio.management.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Singleton {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
