package com.ppa;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.ppa.ioc")
public class MyApp {
	
	@Bean
	@Scope("prototype")
	Date currentDate() {
		return new Date();
	}
	
	@PostConstruct
	void postConstruct() {
		System.out.println("PostConstruct");
	}
	
	@PreDestroy
	void preDestroy() {
		System.out.println("preDestroy");
	}

}
