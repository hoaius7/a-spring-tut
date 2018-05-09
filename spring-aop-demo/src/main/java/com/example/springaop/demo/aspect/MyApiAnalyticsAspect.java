package com.example.springaop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.springaop.demo.Account;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Before("com.example.springaop.demo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Performing API analytics");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method " + methodSig);
		
		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object arg: args) {
			System.out.println(arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}
}
