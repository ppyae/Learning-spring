package com.ppa.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "/application.xml")
@TestMethodOrder(OrderAnnotation.class)
public class PrepareStatementTest {
	
	@Autowired
	private JdbcOperations operations;
	
	@Value("${member.insert}")
	String sql;
	
	@Test
	@Order(1)
	@Sql(scripts = "/database.sql")
	@DisplayName("1. Execute with prepare creator")
	void demo() {
		
		var factory = new PreparedStatementCreatorFactory(sql,new int[] {
			Types.VARCHAR,
			Types.VARCHAR,
			Types.VARCHAR,
			Types.VARCHAR,
		});
		var creator = factory.newPreparedStatementCreator(List.of(
				"admin","Admin User","97398948","admin@gmail.com"
				));
		

//		PreparedStatementCreator creator = con -> {
//			var stm = con.prepareStatement(sql);
//			stm.setString(1, "admin");
//			stm.setString(2, "Admin User");
//			stm.setString(3, "411544555");
//			stm.setString(4, "admin@gmail.com");
//			return stm;
//		};
		var count = operations.execute(creator, PreparedStatement::executeUpdate);
		assertEquals(1, count);
		
		
	}

}
