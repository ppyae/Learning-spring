package com.ppa.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ppa.em.entity.Contact;
import com.ppa.em.entity.Member;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CascadeTest {

	EntityManagerFactory emf;
	
	@BeforeEach
	void init() {
		emf = Persistence.createEntityManagerFactory("entity-manager");
	}
	
	@AfterEach
	void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@ParameterizedTest
	@CsvSource("Thandar,thandar,thandar,03256532,thandar@gami.com")
	void cascade_test(String name,String loginId,String password,String phone,String email) {
		
		var member = new Member(name, loginId, password);
		var contact = new Contact(phone, email);
		member.addContact(contact);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(member);
		em.getTransaction().commit();
	}
}
