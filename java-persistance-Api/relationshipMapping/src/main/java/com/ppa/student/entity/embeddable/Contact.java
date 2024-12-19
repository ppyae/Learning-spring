package com.ppa.student.entity.embeddable;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	@Column(length = 12)
	private String phone;
}
