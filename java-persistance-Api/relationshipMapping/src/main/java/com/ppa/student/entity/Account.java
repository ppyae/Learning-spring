package com.ppa.student.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "account")
public abstract class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Account() {
	}
	
	public Account(String name, String loginId, String password) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(nullable = false,length = 45,name = "login_id")
	private String loginId;
	@Column(nullable = false,length = 45)
	private String password;
	
	
	
	public enum Role{
		Admin,Teacher,Student
	}

}
