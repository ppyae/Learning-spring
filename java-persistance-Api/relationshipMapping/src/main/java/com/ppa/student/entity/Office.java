package com.ppa.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "office")
public class Office extends Account {

	private static final long serialVersionUID = 1L;
	
	public Office() {
		setRole(Role.Admin);
	}
	
	public Office(String name, String loginId, String password) {
		super(name, loginId, password);
		setRole(Role.Admin);
	}




	private boolean admin;

}
