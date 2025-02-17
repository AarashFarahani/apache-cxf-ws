package com.example.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.model.Greeting;

@Service
public class InfoServiceImpl implements InfoService {

	@Override
	public Greeting sayHowAreYou(String name) {
		Greeting greeting = new Greeting();
		greeting.setMessage("How are you " + name + "!!!");
		greeting.setDate(new Date());
		return greeting;
	}
}
