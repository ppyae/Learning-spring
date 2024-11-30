package com.ppa.jdbc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ppa.jdbc.dao.MemberDao;
import com.ppa.jdbc.dto.Member;

@SpringJUnitConfig(locations = "/application.xml")
class MemberTest {
	
	@Autowired
	private MemberDao dao;

	@Test
	@Sql(scripts = "/database.sql")
	void test() {
		
		Member m = new Member();
		m.setLoginId("admin");
		m.setName("Pyae Phyo");
		m.setPhone("0947607040");
		m.setEmail("ko251298@gmail.con");
		
		dao.create(m);
	}

}
