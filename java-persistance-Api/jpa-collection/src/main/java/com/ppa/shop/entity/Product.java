package com.ppa.shop.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
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
	@CollectionTable(name = "product_price", joinColumns = @JoinColumn(name = "product"))
	@MapKeyColumn(name = "price_type")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<PriceType, Integer> price;
	@ElementCollection
	@OrderBy("tags desc")
	private List<String> tags;
	@ElementCollection
	@CollectionTable(name = "product_feature")
	private Set<Feature> feature;
	
	private enum PriceType{
		Retail, Whole_Sale,Special
	}
}
