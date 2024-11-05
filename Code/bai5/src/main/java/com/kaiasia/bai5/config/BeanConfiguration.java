package com.kaiasia.bai5.config;

import com.kaiasia.bai5.controller.ConfigController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

//    @Bean
    public ConfigController configController(){
        return new ConfigController();
    }

}
