package com.ppa.ioc;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	
	public void hello() {
		System.out.println("Hello Ioc Container");
	}

}
