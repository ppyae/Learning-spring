package com.ppa.shop.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	@ElementCollection
	private Map<PriceType, Integer> price;
	@ElementCollection
	private List<String> tags;
	
	private enum PriceType{
		Retail, Whole_Sale,Special
	}
}
