package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repository.HelloRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HelloService {
    
    private final HelloRepository helloRepository;

    public String hello() {
        return helloRepository.hello();
    }

}
