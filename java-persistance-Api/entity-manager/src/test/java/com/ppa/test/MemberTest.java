package com.ppa.test;

import org.junit.jupiter.api.AfterAll;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ppa.em.entity.Member;
import com.ppa.em.entity.Member.Role;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MemberTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("entity-manager");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@ParameterizedTest
	@CsvSource("Pyae Phyo,phyo,phyo")
	void demo(String name,String loginId,String password) {
		
		var member = new Member();
		var em = emf.createEntityManager();
		
		//Transient state
		em.getTransaction().begin();
		
		
		//manage state
		em.persist(member);
		
		assertTrue(em.contains(member));
		
		//Detached state
		em.detach(member);
		
		assertFalse(em.contains(member));
				
		member.setRole(Role.Admin);
		
		//merge state
		member = em.merge(member);//return type of merge can reach manage state
		
		assertTrue(em.contains(member));
		
		//synchornice to database
		em.getTransaction().commit();
		
	}
}
