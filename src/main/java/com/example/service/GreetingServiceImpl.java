package com.example.service;

import com.example.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public Greeting sayHowAreYou(String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage("How are you " + name + "!!!");
        greeting.setDate(new Date());
        return greeting;
    }
}
