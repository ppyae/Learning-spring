package com.ppa.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppa.mvc.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
