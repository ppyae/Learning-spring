package com.ppa.jpa.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Entity
@Data
public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "company_seq")
	@TableGenerator(name = "company_seq",allocationSize = 1, initialValue = 1)
	private int id;
	private String name;
	private String RegisterId;

}
