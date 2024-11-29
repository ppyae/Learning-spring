package com.ppa.aop.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ppa.aop.AppConfig;
import com.ppa.aop.admin.dao.AdminDao;
import com.ppa.aop.member.dao.MemberDao;

@SpringJUnitConfig(classes = AppConfig.class)
public class AdminTest {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Test
	void demo() {
		adminDao.searchMessage();
		memberDao.searchMessage();
	}

}
