package com.ppa.jpa.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "finance")
public class Finance extends Account {

	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToMany(mappedBy = "finance")
	private List<Order> order;
	@OneToMany(mappedBy = "finance")
	private List<Payment> payment;
	
	public enum Role {
		Manager,Supervisor,Staff
	}

}
