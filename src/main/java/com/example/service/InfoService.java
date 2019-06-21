package com.example.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.example.model.Greeting;

@WebService(serviceName = "InfoService")
public interface InfoService {
	@WebMethod
	@WebResult(name = "Greeting")
	public Greeting sayHowAreYou(@WebParam(name = "name") String name);
}
