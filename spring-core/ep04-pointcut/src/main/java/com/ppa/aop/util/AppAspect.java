package com.ppa.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AppAspect {
	
	@Before("CommonPointCut.searchMethod() && CommonPointCut.memberDaoClass()")
	void beforeLog(JoinPoint joinPoint) {
		System.out.println("Before Log");
		System.out.println("===============================");
		System.out.printf("%s-16 : %s%n".formatted("Target Class",joinPoint.getTarget().getClass().getSimpleName()));
		System.out.printf("%s-16 : %s%n".formatted("Target Method",joinPoint.getSignature().getName()));
		System.out.println("===============================");
	}

}
