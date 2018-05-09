package com.example.springaop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springaop.demo.dao.AccountDAO;

public class MainAppAfter {

	public static void main(String[] args) {
		// read spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		
		try { 
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\nMain Program ... caught exception: " + e);
		}
		
		System.out.println("\nMain Program: AfterThrowingDemoApp");
		System.out.println("-----");
		
		System.out.println(accounts);
		
		// close the context
		context.close();
	}

}
