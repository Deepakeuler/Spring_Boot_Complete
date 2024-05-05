package com.example.euler.springboot.springbootdone.common;

import org.springframework.context.annotation.Configuration;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.print("In Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim daily first for forward 50 strokes!";
    }
}
