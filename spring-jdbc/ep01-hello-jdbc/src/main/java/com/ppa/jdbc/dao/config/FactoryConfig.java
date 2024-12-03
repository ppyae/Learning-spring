package com.ppa.jdbc.dao.config;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class FactoryConfig {

	@Bean
	@Qualifier("memberInsert")
	public PreparedStatementCreatorFactory memberInsertCreator(@Value("${member.insert}") String sql) {
		return  new PreparedStatementCreatorFactory(sql,new int[] {
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
			});
	}
	
	@Bean
	@Qualifier("memberFindByName")
	public PreparedStatementCreatorFactory memberSelectCreator(@Value("${member.select}") String sql) {
		return  new PreparedStatementCreatorFactory(sql,new int[] {
				Types.VARCHAR,
			});
	}
	
	@Bean
	@Qualifier("memberFindByPk")
	public PreparedStatementCreatorFactory memberFindByPk(@Value("${member.select.pk}") String sql) {
		return new PreparedStatementCreatorFactory(sql, new int[] {
				Types.VARCHAR,
		});
	}
}
