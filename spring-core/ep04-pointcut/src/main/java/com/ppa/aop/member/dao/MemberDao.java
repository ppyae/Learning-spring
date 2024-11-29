package com.ppa.aop.member.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	public void searchMessage() {
		System.out.println("Member search message");
	}
}
