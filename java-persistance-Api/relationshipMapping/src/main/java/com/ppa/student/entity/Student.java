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
	
	@ManyToMany
	private List<Section> classes;
	
	@OneToOne(mappedBy = "student")
	private Address address;

}
