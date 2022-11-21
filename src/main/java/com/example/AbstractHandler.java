package com.example;

import java.lang.reflect.ParameterizedType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public abstract class AbstractHandler<T> {

    // Spring IOC application context
    public ApplicationContext applicationContext;

    public AbstractHandler() {
        // Gets config class to create an Application context
        Class<T> configClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        //  check if T has @Configuration annotation
        if (configClass.isAnnotationPresent(Configuration.class)) {
            applicationContext = new AnnotationConfigApplicationContext(configClass);
        }
        // create Spring application context
        applicationContext = new AnnotationConfigApplicationContext(configClass);
    }
    
}