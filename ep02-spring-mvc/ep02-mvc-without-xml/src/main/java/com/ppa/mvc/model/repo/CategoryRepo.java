package com.ppa.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppa.mvc.model.entity.OrderItem;

public interface CategoryRepo extends JpaRepository<OrderItem, Integer> {

}
