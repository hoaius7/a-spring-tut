package com.example.springaop.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.springaop.demo.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	
	@AfterReturning(pointcut = "execution(* com.example.springaop.demo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n=====>>> result is: " + result);
		
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=====>>> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> accounts) {
		for (Account account: accounts) {
			account.setName(account.getName().toUpperCase());
		}
	}
	
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
	
	@Before("com.example.springaop.demo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeOnAnyMethodClassInPackage() {
		System.out.println("\n=====>>> Executing @Before advice on any method, class in a package");
	}
	
}
