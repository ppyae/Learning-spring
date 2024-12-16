package com.ppa.student.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 45)
	private String name;
	@Lob
	private String description;
	@Enumerated(EnumType.STRING)
	private Level level;
	private int hours;
	@OneToMany
	@JoinTable(joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "class_id"))
	private List<Section> sections;
	
	public enum Level{
		Basic,Intermediate,Advance
	}
}
