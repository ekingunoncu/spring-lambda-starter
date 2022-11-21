package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.service.HelloService;

public class AppTest extends AbstractHandler<SpringConfig> {

    // it's better to go with TDD to make sure our implementations are working 
    // since out environment going to be AWS Lambda container
    @Test
    public void hello() {
        // get the service bean from the context an trigger the hello method
        HelloService helloService = applicationContext.getBean(HelloService.class);
        String message = helloService.hello();
        // test if message contains "Hello World!"
        assertEquals(message, "Hello World!");
    }

}
