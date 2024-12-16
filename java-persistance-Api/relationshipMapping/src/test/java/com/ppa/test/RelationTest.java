package com.ppa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ppa.student.entity.Account;
import com.ppa.student.entity.Account.Role;
import com.ppa.student.entity.Address;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RelationTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("relationshipMapping");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void demo() {
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//create account
		var account = new Account();
		account.setLoginId("Thandar");
		account.setName("Thandar");
		account.setPassword("thandar");
		account.setRole(Role.Admin);
		em.persist(account);
		
		assertEquals(1, account.getId());
		
		//create address
		var address = new Address();
		address.setStreet("Pridi 32");
		address.setAccount(account);
		address.setTownShip("Bangkok");
		address.setCountry("Thailand");
		em.persist(address);
		
		assertEquals(1, address.getId());
		em.getTransaction().commit();
	}
}
