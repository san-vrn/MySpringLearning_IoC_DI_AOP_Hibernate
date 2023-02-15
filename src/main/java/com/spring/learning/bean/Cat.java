package com.spring.learning.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("catBean")
public class Cat implements Pet{

    @Value("${cat.say}")
    String catSay;

    @Override
    public void say() {
        System.out.println(catSay);
    }
}
