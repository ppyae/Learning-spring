package com.ppa.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ppa.aop.record.RecordMessage;

@Component
@Aspect
public class MessageAspect {
	
	@Before(value = "bean(myService) && args(id,..)",argNames = "id")
	public void doBefore(int id) {
		System.out.println("Techonology code do before");
		System.out.println("Id is %d".formatted(id));
	}
	
	@AfterReturning(
			pointcut ="bean(myService) && execution(com.ppa..RecordMessage *(..)) && args(name,id)",
			argNames = "message,name,id",
			returning  = "message"
			)
	public void afterReturning(RecordMessage message,int id, String name) {
		System.out.println("Techonology code do after returning");
		System.out.println("Args Name : %s".formatted(name));
		System.out.println("Args id : %d".formatted(id));
		System.out.println(message);
	}
	
	@AfterThrowing(
			value = "bean(myService)",
			throwing = "e"
			)
	public void afterTrowing(RuntimeException e) {
		System.out.println("Techonology code do after trowing");
		System.out.println(e.getClass().getSimpleName());
		System.out.println(e.getMessage());
	}
	
	@After(value ="bean(myService) && args(*,name)", argNames = "name")
	public void doAfter(String name) {
		System.out.println("Techonology code do after");
		System.out.println("Name is %s".formatted(name));
	}
	
	@Around(value = "bean(myService) && args(id,name)", argNames = "id,name")
	Object aroundInvoke(ProceedingJoinPoint joinPoint,int id,String name) {
		
		Object result = null;
		System.out.println("Around Before method");
		System.out.println("Id is %d and Name is %s".formatted(id,name));
		
		try {
			result = joinPoint.proceed();
			System.out.println("Around After returning");
			
		} catch (Throwable e) {
			System.out.println("Around After Trowing");
			throw new RuntimeException(e);
		}finally {
			System.out.println("Around Aftrer finally");
		}
		return result;
	}

}
