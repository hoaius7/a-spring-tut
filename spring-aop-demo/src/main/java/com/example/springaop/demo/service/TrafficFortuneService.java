package com.example.springaop.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public 	String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Expect heavy traffic this morning!";
	}

	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		
		return getFortune();
	}
}
