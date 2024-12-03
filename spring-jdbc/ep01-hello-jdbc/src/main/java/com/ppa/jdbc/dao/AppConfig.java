package com.ppa.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@ComponentScan("com.ppa.jdbc.dao")
@PropertySource(value  = "/database.properties,/sql.properties")
public class AppConfig {
	
	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		
		var config = new BoneCPConfig();
		config.setJdbcUrl(url);
		config.setUser(user);
		config.setPassword(password);
		return new BoneCPDataSource(config);
		
//		var ds = new MysqlConnectionPoolDataSource();
//		ds.setUrl(url);
//		ds.setUser(user);
//		ds.setPassword(password);
//		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource,true);
	}

}
