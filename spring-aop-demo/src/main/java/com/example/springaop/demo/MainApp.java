package com.example.springaop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springaop.demo.dao.AccountDAO;
import com.example.springaop.demo.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {
		// read spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		accountDAO.addAccount();
		
		membershipDAO.addAccount();
		
		// close the context
		context.close();
	}

}
