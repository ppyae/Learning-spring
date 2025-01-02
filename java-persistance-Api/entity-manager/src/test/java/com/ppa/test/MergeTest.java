package com.ppa.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.ppa.em.entity.Member;

public class MergeTest extends OperationTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/members.csv")
	void mergeToPersist(int id,String name,String loginId,String password) {
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var member = new Member(name, loginId, password);
		member = em.merge(member);
		assertEquals(id, member.getId());
		em.getTransaction().commit();
		
		
	}
}
