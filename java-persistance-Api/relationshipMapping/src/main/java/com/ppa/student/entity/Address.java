package com.ppa.student.entity;

import java.io.Serializable;

import com.ppa.student.entity.embeddable.Contact;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable = false)
	private String street;
	@Column(name = "town_ship",nullable = false)
	private String TownShip;
	@Column(nullable = false)
	private String Country;
	
	private Contact contact;
	@AttributeOverrides({
		@AttributeOverride(name = "email",column = @Column(name = "sec_email")),
		@AttributeOverride(name = "phone",column = @Column(name = "sec_phone",length = 12))
	})
	private Contact secondaryContact;
	
	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	@MapsId
	private Student student;

}
