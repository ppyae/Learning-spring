package com.ppa.shopping.model;

import java.util.ArrayList;
import java.util.List;

import com.ppa.shopping.model.entity.Product;

public class ProductModel {
	
	private List<Product> products = new ArrayList<Product>();
	
	public ProductModel() {
		
		products.add(new Product(1, "Pepsi", "Drink", 50));
		products.add(new Product(2, "Coke", "Drink", 60));
		products.add(new Product(3, "Potato Chip", "Snacks", 30));
		products.add(new Product(4, "Fish Chip", "Snacks", 35));
	}
	
	public List<Product> getProducts() {
		return new ArrayList<Product>();
	}

	public Product findById(int id) {
		return products.stream().filter(a -> a.id() == id).findAny().orElse(null);
	}
}
