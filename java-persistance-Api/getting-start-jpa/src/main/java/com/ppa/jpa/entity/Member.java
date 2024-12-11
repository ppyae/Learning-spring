package com.ppa.jpa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "member_tb", uniqueConstraints = @UniqueConstraint(columnNames = {
		"email" }))
@SecondaryTable(name = "login_info", indexes = @Index(columnList = "role"))
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "member_seq")
	@TableGenerator(name = "member_seq",allocationSize = 1,initialValue = 200)
	private int id;
	private String name;

	@Column(table = "login_info")
	private String LoginId;
	@Column(table = "login_info")
	private String password;
	@Column(table = "login_info")
	@Enumerated(EnumType.STRING)
	private Role role;

	private Contact contact;

	public enum Role {
		Manager, Supervisor, Staff
	}

}
