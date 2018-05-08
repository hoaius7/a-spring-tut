package com.example.springaop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	@Before("execution(public void com.example.springaop.demo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountOnAccountDAOAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on AccountDAO.addAccount()");
	}

	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}

	@Before("execution(public void add*())")
	public void beforeAddAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on add*()");
	}

	@Before("execution(* add*())")
	public void beforeAddAnyReturnAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on add* that return anything()");
	}

}
