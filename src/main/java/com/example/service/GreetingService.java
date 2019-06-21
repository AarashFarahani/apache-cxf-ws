package com.example.service;

import com.example.model.Greeting;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "GreetingService")
public interface GreetingService {
    @WebMethod
    @WebResult(name = "Greeting")
    public Greeting sayHowAreYou(@WebParam(name = "name") String name);
}
