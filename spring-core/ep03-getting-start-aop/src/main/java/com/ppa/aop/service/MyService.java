package com.ppa.aop.service;

import org.springframework.stereotype.Service;

import com.ppa.aop.record.RecordMessage;

@Service
public class MyService  {

	public RecordMessage doBusiness(int id, String name) {
		System.out.println("Hello Aspect J style ");
		return new RecordMessage(name, id);
	};
	
	public int divided(int a, int b) {
		return a/b;
	}
}
