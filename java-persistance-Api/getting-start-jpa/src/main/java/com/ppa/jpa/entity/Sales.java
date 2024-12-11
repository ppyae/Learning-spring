package com.ppa.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Sales implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SalePk pk;
	private int id;
	@Column(nullable = false)
	private int sale;
	@Column(name = "sale_date")
	@Temporal(TemporalType.DATE)
	private Date saleDate;
	@Lob
	private String description;
	
	@Transient
	private boolean deleted;

}
