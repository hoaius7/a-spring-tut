package com.example.springaop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	
	@Pointcut("execution(* com.example.springaop.demo.dao.*.*(..))")
	private void forDaoPackage() {}
	

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

	@Before("execution(* add*(com.example.springaop.demo.Account))")
	public void beforeAddWithAccountParam() {
		System.out.println("\n=====>>> Executing @Before advice on add* that have Account param()");
	}
	
	@Before("execution(* add*(com.example.springaop.demo.Account, ..))")
	public void beforeAddWithAccountParamAndOtherParams() {
		System.out.println("\n=====>>> Executing @Before advice on add* that have Account param and other params");
	}
	
	@Before("execution(* add*(..))")
	public void beforeAddWithAnyParam() {
		System.out.println("\n=====>>> Executing @Before advice on add* that have any params");
	}
	
	@Before("forDaoPackage()")
	public void beforeOnAnyMethodClassInPackage() {
		System.out.println("\n=====>>> Executing @Before advice on any method, class in a package");
	}
	
}
