package com.ppa.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ppa.ioc.HelloBean;
import com.ppa.ioc.HelloXml;

public class HelloTest {

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext("com.ppa.ioc")){
			
//			context.scan("com.ppa.ioc");
//			context.refresh();
			
			var bean = context.getBean(HelloBean.class);
			bean.hello();
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
