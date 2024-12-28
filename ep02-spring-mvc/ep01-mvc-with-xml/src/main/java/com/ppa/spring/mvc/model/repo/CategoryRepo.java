package com.ppa.spring.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppa.spring.mvc.model.entity.OrderItem;

public interface CategoryRepo extends JpaRepository<OrderItem, Integer> {

}
