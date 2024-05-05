package com.example.euler.springboot.springbootdone.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("in Constructor of: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "practice for 60 minutes daily";
    }
}
