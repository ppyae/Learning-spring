package com.ppa.jpa.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ppa.jpa.entity.Company;
import com.ppa.jpa.entity.Member;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("helloJpa");
		
	}
	
	@AfterAll
	static void close() {
		
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
		
	}
	
	@Test
	void demo() {
		var member = new Member();
		member.setName("Aung AUng");
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(member);
		System.out.println("Member id is %s".formatted(member.getId()));
		
		var company = new Company();
		company.setName("Phyo Coltd");
		em.persist(company);
		System.out.println("Company id is %s".formatted(company.getId()));
		em.getTransaction().commit();
	}
}
