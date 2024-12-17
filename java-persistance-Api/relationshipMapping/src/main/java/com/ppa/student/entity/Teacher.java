package com.ppa.student.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "teacher")
public class Teacher extends Account {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "teacher")
	private List<Section> sections;
	
	
}
