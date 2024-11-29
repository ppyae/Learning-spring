package com.ppa.aop.admin.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	
	public void searchMessage() {
		System.out.println("Admin search message");
	}
	
	public void saveMessage() {
		System.out.println("Admin save message");
	}

}
