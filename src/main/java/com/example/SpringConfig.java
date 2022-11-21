package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.example.repository.HelloRepository;
import com.example.service.HelloService;

@Configuration
@PropertySource("classpath:application.yml")
// this is very important, otherwise you will get a null pointer exception
// importing with @Import is way much faster than component scanning which make our cold star much faster
@Import(value = { HelloService.class, HelloRepository.class })
public class SpringConfig {

}