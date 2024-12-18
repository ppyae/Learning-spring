package com.ppa.student.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "student")
public class Student extends Account {

	private static final long serialVersionUID = 1L;
	
	public Student() {
		setRole(Role.Student);
	}

	public Student(String name, String loginId, String password) {
		super(name, loginId, password);
		setRole(Role.Student);
	}


	@ManyToMany
	private List<Section> classes;
	
	@OneToOne(mappedBy = "student")
	private Address address;

}
