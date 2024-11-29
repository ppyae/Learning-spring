package com.ppa.aop.admin.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

	public void doBusiness() {
		System.out.println("Admin service do");
	}
	
	public void doAccount() {
		System.out.println("Admin do account");
	}
}
