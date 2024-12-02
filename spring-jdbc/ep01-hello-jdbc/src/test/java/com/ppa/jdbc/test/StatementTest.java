package com.ppa.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

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
class StatementTest {

	@Autowired
	private JdbcOperations operations;

	@Autowired
	private MemberDao dao;

	@Test
	@Sql(scripts = "/database.sql")
	@Order(1)
	void demo() {

		Member m = new Member();
		m.setLoginId("ppa");
		m.setName("Pyae");
		m.setPhone("9348930");

		dao.create(m);

	}

	@Test
	@Order(2)
	void test() {

		var data = operations.execute((Connection con) -> {
			var stm = con.createStatement();
			var rs = stm.executeQuery("select count(*) from member");
			while (rs.next()) {
				return rs.getLong(1);
			}
			return 0;
		});

		assertEquals(1L, data);

	}

	@Test
	@Order(3)
	void statement() {
		var data = operations.execute((Statement stm) -> {
			return stm.executeUpdate("""
					insert into member(loginId,name,phone) values
					('thandar','Thandar','9384673839')

					""");

		});
		assertEquals(1, data);

	}

	@Test
	@Order(4)
	void staticQueryRowExtractor() {

		var data = operations.query("select count(*) from member", rs -> {
			while (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		});

		assertEquals(2, data);

		var list = operations.query("select * from member", rs -> {

			var result = new ArrayList<Member>();
			while (rs.next()) {
				var m = new Member();
				m.setLoginId(rs.getString(1));
				m.setName(rs.getString(2));
				m.setPhone(rs.getString(3));
				m.setEmail(rs.getString(4));

				result.add(m);

			}
			return result;
		});

		assertEquals(2, list.size());

	}
	
	@Test
	@Order(5)
	void testRowCallBackHandler() {

		var arr = new ArrayList<Member>();
		operations.query("select * from member", rs -> {
			var m = new Member();
			m.setLoginId(rs.getString(1));
			m.setName(rs.getString(2));
			m.setPhone(rs.getString(3));
			m.setEmail(rs.getString(4));

			arr.add(m);
		});
		assertEquals(2, arr.size());
	}

	@Test
	@Order(6)
	void testRowMapper() {
		var list = operations.query("select * from member", 
				(rs, no) -> {
					var m = new Member();
					m.setLoginId(rs.getString(1));
					m.setName(rs.getString(2));
					m.setPhone(rs.getString(3));
					m.setEmail(rs.getString(4));
					return m;
				});
		assertEquals(2, list.size());
	}

}
