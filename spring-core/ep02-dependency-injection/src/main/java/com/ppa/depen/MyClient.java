package com.ppa.depen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ppa.depen.xml.MyClientService;

@Configuration
@ComponentScan("com.ppa.depen.xml")
public class MyClient {
	
	@Autowired
	private MyClientService service;
	
	public void doBusiness() {
		service.clientService();
	}

}
