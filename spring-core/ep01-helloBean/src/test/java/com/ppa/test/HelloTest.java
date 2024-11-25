package com.ppa.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ppa.ioc.HelloBean;

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
}
