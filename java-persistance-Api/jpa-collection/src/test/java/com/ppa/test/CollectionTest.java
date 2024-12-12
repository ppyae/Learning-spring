package com.ppa.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CollectionTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jpa-collection");
	
	}
	
	@AfterAll
	static void close() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void demo() {
		
	}
}
