package com.example.euler.springboot.springbootdone.Config;

import com.example.euler.springboot.springbootdone.common.Coach;
import com.example.euler.springboot.springbootdone.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
