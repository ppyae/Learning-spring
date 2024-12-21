package com.ppa.student.entity.embeddable;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RegisterationPk implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "section_id")
	private int sectionId;
}
