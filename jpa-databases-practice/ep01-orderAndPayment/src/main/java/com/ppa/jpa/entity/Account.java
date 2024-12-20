package com.ppa.jpa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Account() {
		
	}
	
	public Account(String userName, String loginId, String password) {
		super();
		this.userName = userName;
		this.loginId = loginId;
		this.password = password;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_name",nullable = false)
	private String userName;
	@Column(name = "login_id",nullable = false)
	private String loginId;
	@Column(nullable = false,length = 8)
	private String password;
	
	

}
