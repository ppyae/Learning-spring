package com.ppa.aop.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ppa.aop.controller.AppController;
import com.ppa.aop.service.MyService;

@SpringJUnitConfig(classes = AppController.class)
public class AopTest {
	
	@Autowired
	private  MyService service;
	
	@Test
	void demo() {
		service.doBusiness(1,"Pyae Phyo");
		service.divided(10, 2);
	}

}
