package com.ppa.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ppa.jdbc.dao.config.MapRow;
import com.ppa.jdbc.dto.Member;

@SpringJUnitConfig(locations = "/application.xml")
@TestMethodOrder(OrderAnnotation.class)
public class PrepareStatementTest {
	
	@Autowired
	private JdbcOperations operations;
	
	@Autowired
	private MapRow rowMapper;
	
	@Test
	@Order(1)
	@Sql(scripts = "/database.sql")
	@DisplayName("1. Execute with prepare creator")
	void demo(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {
		
		var creator = factory.newPreparedStatementCreator(List.of(
				"admin","Admin User","97398948","admin@gmail.com"
				));
		

//		PreparedStatementCreator creator = con -> {
//			var stm = con.prepareStatement(sql);
//			stm.setString(1, "admin") ;
//			stm.setString(2, "Admin User");
//			stm.setString(3, "411544555");
//			stm.setString(4, "admin@gmail.com");
//			return stm;
//		};
		var count = operations.execute(creator, PreparedStatement::executeUpdate);
		assertEquals(1, count);		
	}
	
	@Test
	@Order(2)
	@DisplayName("2. update with prepare creator")
	void demo1(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {
		
		var creator = factory.newPreparedStatementCreator(List.of(
				"member","Aung Aung","21548481","aung@gmail.com"
				));

		var count = operations.update(creator);
		assertEquals(1, count);		
	}
	
	@Test
	@Order(3)
	@DisplayName("3. select with prepare creator")
	void demo2(@Qualifier("memberFindByName") PreparedStatementCreatorFactory factory) {
		
		var result = operations.execute(factory.newPreparedStatementCreator(List.of("Admin%")),stm -> {
			var list = new ArrayList<Member>();
			var rs = stm.executeQuery();
			while(rs.next()) {
				var m = new Member();
				m.setLoginId(rs.getString(1));
				m.setName(rs.getString(2));
				m.setPhone(rs.getString(3));
				m.setEmail(rs.getString(4));
				list.add(m);
			}
			return list;
		});
		assertEquals(1, result.size());
	}
	
	@Test
	@Order(4)
	@DisplayName("4.Quetry find by name with prepare creator")
	void demo3(@Qualifier("memberFindByName") PreparedStatementCreatorFactory factory) {
		
		var result = operations.query(factory.newPreparedStatementCreator(List.of("Admin%")), rowMapper);
	}
	
	@Test
	@Order(5)
	@DisplayName("5.Quetry find by id with prepare creator")
	void demo4(@Qualifier("memberFindByPk") PreparedStatementCreatorFactory factory) {
		var result = operations.query(factory.newPreparedStatementCreator(List.of("member")),rs -> {
			while(rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			return null;
		});
		assertNotNull(result);
		assertEquals("Aung Aung", result.getName());
	}

}
