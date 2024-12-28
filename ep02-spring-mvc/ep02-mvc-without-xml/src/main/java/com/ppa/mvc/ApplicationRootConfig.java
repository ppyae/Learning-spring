package com.ppa.mvc;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ppa.mvc.model.repo")
@ComponentScan(basePackages = "com.ppa.mvc.model")
public class ApplicationRootConfig {

	@Bean
	DataSource dataSource() {
		var ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/sale_db");
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource());
		emfb.setPackagesToScan("com.ppa.mvc.model.entity");
		emfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		emfb.setJpaPropertyMap(Map.of(
				"hibernate.show_sql",true,
				"hibernate.format_sql",true
				));
		return emfb;
	}
	
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
