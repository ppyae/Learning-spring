package com.ppa.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "member_tb", uniqueConstraints = @UniqueConstraint(columnNames = {
		"email" }))
@SecondaryTable(name = "login_info", indexes = @Index(columnList = "role"))
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(table = "login_info")
	private String LoginId;
	@Column(table = "login_info")
	private String password;
	@Column(table = "login_info")
	private Role role;

	private Contact contact;

	public enum Role {
		Manager, Supervisor, Staff
	}

}
