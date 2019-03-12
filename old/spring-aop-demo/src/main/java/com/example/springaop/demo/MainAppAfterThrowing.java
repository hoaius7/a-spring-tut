package com.example.springaop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springaop.demo.dao.AccountDAO;

public class MainAppAfterThrowing {

	public static void main(String[] args) {
		// read spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts(false);
		
		System.out.println("\nMain Program: AfterReturningDemoApp");
		System.out.println("-----");
		
		System.out.println(accounts);
		
		// close the context
		context.close();
	}

}
