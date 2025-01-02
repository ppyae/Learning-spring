package com.ppa.em.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "contact")
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 12)
	private String phone;
	@Column(length = 20)
	private String email;
	@ManyToOne
	private Member member;
	
	public Contact() {
		
	}

	public Contact(String phone, String email) {
		this.phone = phone;
		this.email = email;
	}
	
	

}
