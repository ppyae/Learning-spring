package com.ppa.student.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "class")
public class Section implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "start_time")
	private LocalDate startTime;
	@Column(name = "end_time")
	private LocalDate endTime;
	@Column(name = "end_date")
	private LocalDate endDate;
	private Double duration;
	@ManyToOne
	private Teacher teacher;
}
