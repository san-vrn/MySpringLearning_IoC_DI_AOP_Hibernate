package com.spring.learning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.spring.learning")
@PropertySource(value = {"classpath:name.properties",  "classpath:application.properties"})
@EnableAspectJAutoProxy
public class Config {
}
