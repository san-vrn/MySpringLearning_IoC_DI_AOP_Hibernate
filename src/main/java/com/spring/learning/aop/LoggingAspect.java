package com.spring.learning.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before(value = "execution(public void say())")
    public void logging(){
        System.out.println("log записан");
        log.info("выполнена команда 'say'");
    }
}
