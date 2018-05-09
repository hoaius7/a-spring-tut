package com.example.springaop.demo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.springaop.demo.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	
	private Logger logger = Logger.getLogger(MyLoggingAspect.class.getName());
	
	@Around("execution(* com.example.springaop.demo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
				
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			logger.warning(e.getMessage());
			
			// give user a custom message
			result = "Major accident! But no worries, your private AOP helicopter is on the way";
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		logger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.example.springaop.demo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @After on method: " + method);
	}
	
	@AfterThrowing(pointcut = "execution(* com.example.springaop.demo.dao.AccountDAO.findAccounts(..))",
			throwing = "exp")
	public void afterThrowingFindAccoundsAdvice(JoinPoint joinPoint, Throwable exp) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		logger.info("\n=====>>> The exception is: " + exp);
	}
	
	@AfterReturning(pointcut = "execution(* com.example.springaop.demo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @AfterReturning on method: " + method);
		
		logger.info("\n=====>>> result is: " + result);
		
		convertAccountNamesToUpperCase(result);
		
		logger.info("\n=====>>> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> accounts) {
		for (Account account: accounts) {
			account.setName(account.getName().toUpperCase());
		}
	}
	
	@Before("execution(public void com.example.springaop.demo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountOnAccountDAOAdvice() {
		logger.info("\n=====>>> Executing @Before advice on AccountDAO.addAccount()");
	}

	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		logger.info("\n=====>>> Executing @Before advice on addAccount()");
	}

	@Before("execution(public void add*())")
	public void beforeAddAdvice() {
		logger.info("\n=====>>> Executing @Before advice on add*()");
	}

	@Before("execution(* add*())")
	public void beforeAddAnyReturnAdvice() {
		logger.info("\n=====>>> Executing @Before advice on add* that return anything()");
	}

	@Before("execution(* add*(com.example.springaop.demo.Account))")
	public void beforeAddWithAccountParam() {
		logger.info("\n=====>>> Executing @Before advice on add* that have Account param()");
	}
	
	@Before("execution(* add*(com.example.springaop.demo.Account, ..))")
	public void beforeAddWithAccountParamAndOtherParams() {
		logger.info("\n=====>>> Executing @Before advice on add* that have Account param and other params");
	}
	
	@Before("execution(* add*(..))")
	public void beforeAddWithAnyParam() {
		logger.info("\n=====>>> Executing @Before advice on add* that have any params");
	}
	
	@Before("com.example.springaop.demo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeOnAnyMethodClassInPackage() {
		logger.info("\n=====>>> Executing @Before advice on any method, class in a package");
	}
	
}
