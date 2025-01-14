package com.ppa.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppa.mvc.model.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
