package com.ppa.jpa.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Sales implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SalePk pk;
	private int id;
	private int sale;
	private String description;

}
