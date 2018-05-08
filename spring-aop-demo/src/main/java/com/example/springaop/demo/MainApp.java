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
		
		accountDAO.addSomething();
		
		membershipDAO.addAccount();
		
		Account account = new Account();
		accountDAO.addAccount(account);
		accountDAO.addAccount(account, true);
		
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		
		accountDAO.getName();
		accountDAO.getServiceCode();
		
		// close the context
		context.close();
	}

}
