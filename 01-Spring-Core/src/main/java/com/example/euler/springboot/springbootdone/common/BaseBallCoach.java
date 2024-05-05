package com.example.euler.springboot.springbootdone.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class BaseBallCoach implements Coach{

    public BaseBallCoach(){
        System.out.println("in Constructor of: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes in batting practice";
    }
}
