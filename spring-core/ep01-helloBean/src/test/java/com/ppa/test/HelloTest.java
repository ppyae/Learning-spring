package com.ppa.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ppa.MyApp;
import com.ppa.ioc.HelloBean;
import com.ppa.ioc.HelloXml;

public class HelloTest {

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext(MyApp.class)){
			
//			context.scan("com.ppa.ioc");
//			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.hello();
			var date = context.getBean(Date.class);
			var date1 = context.getBean(Date.class);
			System.out.println(date);
			
			//scope test
			assertTrue(date != date1);
		}
	}
	
	@Test
	void xmlTest() {
		
		try(var context = new GenericXmlApplicationContext("classpath:context.xml")){
			
//			context.load("classpath:context.xml");
//			context.refresh();
			
			var bean = context.getBean(HelloXml.class);
			bean.greet();
		}
	}
}
