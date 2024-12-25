package com.ppa.test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hibernate.LazyInitializationException;

import static org.junit.jupiter.api.Assertions.assertAll; 
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.ppa.em.entity.Member;
import com.ppa.em.entity.Member.Role;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
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
	
	@Order(1)
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
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void find(int id) {
		
		var em = emf.createEntityManager();
		var member = em.find(Member.class, id);
		assertNotNull(member);
		assertTrue(em.contains(member));
		
		em.detach(member);
		
		assertAll(
				()-> assertEquals("phyo", member.getLoginId()),
				()-> assertEquals("phyo", member.getPassword())
		);
		
	}
	
	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void getReference(int id) {
		
		var em = emf.createEntityManager();
		var member = em.getReference(Member.class, id);
		assertNotNull(member);
		assertTrue(em.contains(member));
		em.detach(member);
		
		assertAll(
				() -> assertThrows(LazyInitializationException.class,() -> member.getLoginId()),
				() -> assertThrows(LazyInitializationException.class, () -> member.getPassword())
		);
	}
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(ints = 4)
	void findMethodNotFound(int id) {
		var em = emf.createEntityManager();
		var member = em.find(Member.class, id);
		assertNull(member);
	}
	
	@Order(5)
	@ParameterizedTest
	@ValueSource(ints = 4)
	void getReferenceNotFound(int id) {
		var em = emf.createEntityManager();
		var member = em.getReference(Member.class, id);
		//found MemberHibernate Proxy obj
		assertNotNull(member);
		
		assertThrows(EntityNotFoundException.class, ()-> member.setName("Thida"));
		assertThrows(EntityNotFoundException.class, member::getName);
	}
}
