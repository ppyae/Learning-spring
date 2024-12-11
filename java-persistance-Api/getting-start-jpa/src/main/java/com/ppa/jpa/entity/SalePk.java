package com.ppa.jpa.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
@Data
public class SalePk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int seqId;
	private int transationType;
}
