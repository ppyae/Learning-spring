package com.ppa.student.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.ppa.student.entity.embeddable.RegisterationPk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "registeration")
public class Registeration implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RegisterationPk registerationPk;
	@ManyToOne
	@MapsId("studentId")
	private Student student;
	@ManyToOne
	@MapsId("sectionId")
	private Section section;
	@Column(name = "register_date",nullable = false)
	private LocalDate registerDate;
	@Column(name = "paid_amount")
	private int paidAmount;
	

}
