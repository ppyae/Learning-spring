package com.ppa.aop.member.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	public void doBusiness() {
		System.out.println("Member do business");
	}
}
