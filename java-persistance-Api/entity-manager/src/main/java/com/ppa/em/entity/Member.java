package com.ppa.em.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Member() {
		contacts = new ArrayList<>();
		
	}
	
	public Member(String name, String loginId, String password) {
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.role = Role.Member;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "login_id")
	private String loginId;
	@Column(length = 8)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> tags;
	@OneToMany(mappedBy = "member",orphanRemoval = true,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	private List<Contact> contacts;
	
	public enum Role{
		Admin,Member
	}
	
	public void addContact(Contact c) {
		this.contacts = new ArrayList<>();
		contacts.add(c);
	}

}
