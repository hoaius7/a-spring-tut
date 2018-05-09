package com.example.springaop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springaop.demo.service.TrafficFortuneService;

public class MainAppAround {

	public static void main(String[] args) {
		// read spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from Spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		System.out.println("\nMain Program: MainAppAround");
		System.out.println("Calling getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");

		// close the context
		context.close();
	}

}
