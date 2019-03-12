package com.example.springaop.demo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springaop.demo.service.TrafficFortuneService;

public class MainAppAround {
	
	private static Logger logger = Logger.getLogger(MainAppAround.class.getName());

	public static void main(String[] args) {
		// read spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from Spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		logger.info("\nMain Program: MainAppAround");
		logger.info("Calling getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		logger.info("\nMy fortune is: " + data);
		logger.info("Finished");

		// close the context
		context.close();
	}

}
