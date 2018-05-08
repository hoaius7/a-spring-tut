package com.example.springaop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springaop.demo.dao.AccountDAO;

public class MainApp {

	public static void main(String[] args) {
		// read spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		accountDAO.addAccount();
		
		// close the context
		context.close();
	}

}
