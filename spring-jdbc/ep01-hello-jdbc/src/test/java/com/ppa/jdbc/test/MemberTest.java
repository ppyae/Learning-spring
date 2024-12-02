package com.ppa.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ppa.jdbc.dao.AppConfig;
import com.ppa.jdbc.dao.MemberDao;
import com.ppa.jdbc.dto.Member;

@SpringJUnitConfig(classes = AppConfig.class)
@TestMethodOrder(OrderAnnotation.class)
class MemberTest {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private JdbcOperations operations;

	@Test
	@Sql(scripts = "/database.sql")
	@Order(1)
	void test() {
		
		Member m = new Member();
		m.setLoginId("admin");
		m.setName("Pyae Phyo");
		m.setPhone("0947607040");
		m.setEmail("ko251298@gmail.con");
		
		dao.create(m);
	}

	@Test
	@Order(2)
	void staticQuerySingleResultWithClass() {
		var admin = operations.queryForObject("select name from member where loginId = 'admin'", String.class);
		assertEquals("Pyae Phyo",admin);
	}

}
