package com.ppa.shop.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode
public class Feature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String feature;

}
