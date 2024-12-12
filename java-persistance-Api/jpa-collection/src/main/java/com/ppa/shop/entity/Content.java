package com.ppa.shop.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OrderColumn;
import lombok.Data;

@Embeddable
@Data
public class Content implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String address;
	@ElementCollection
	@OrderColumn(name = "email_order")
	private List<String> email;

}
