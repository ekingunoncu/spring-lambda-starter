package com.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
    
    // of course not an actual repository, just a dummy method
    // just wanted to show if you get a the service bean from the context, you can use it directly
    public String hello() {
        return "Hello World!";
    }

}
