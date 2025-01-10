package com.ppa.hotel.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class AccountAbstract implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String name;
	@Column(name = "login_id",nullable = false)
	private String loginId;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToOne
	private Customer customers;
	
	public enum Role{
		Owner,Manager,Supervisor,Reception,Chef
	}
	

}
