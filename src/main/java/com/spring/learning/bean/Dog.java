package com.spring.learning.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet{
    @Value("${dog.say}")
    String dogSay;

    @Override
    public void say() {
        System.out.println(dogSay);
    }
}
