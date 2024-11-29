package com.ppa.aop.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonPointCut {
	
	@Pointcut("execution(* search*(..))")
	void searchMethod() {}
	
	@Pointcut("within(com..member.dao.*)")
	void memberDaoClass() {}

}
