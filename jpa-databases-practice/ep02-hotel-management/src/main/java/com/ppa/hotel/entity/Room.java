package com.ppa.hotel.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "room")
public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private short roomNumber;
	private boolean available;
	@OneToOne
	private Customer customer;
	@ManyToOne
	private Reception reception;
	@OneToOne
	private Payment payment;

}
