package com.example.euler.springboot.springbootdone.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("in Constructor of: "+getClass().getSimpleName());
    }

    //define init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyClosingStuff(){
        System.out.println("In doMyClosingStuff(): "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes!!";
    }
}
