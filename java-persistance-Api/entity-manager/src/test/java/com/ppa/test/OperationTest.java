package com.ppa.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OperationTest {
	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void index() {
		emf = Persistence.createEntityManagerFactory("entity-manager");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}

}
