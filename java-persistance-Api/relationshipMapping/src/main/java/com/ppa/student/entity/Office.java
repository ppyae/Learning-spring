package com.ppa.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "office")
public class Office extends Account {

	private static final long serialVersionUID = 1L;
	
	private boolean admin;

}
