package com.example.springaop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.example.springaop.demo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcuts for getter and setter
	@Pointcut("execution(* com.example.springaop.demo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.example.springaop.demo.dao.*.set*(..))")
	public void setter() {}
	
	// pointcut that include package, but exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	

}
