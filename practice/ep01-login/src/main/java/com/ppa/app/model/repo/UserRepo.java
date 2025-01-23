package com.ppa.app.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppa.app.model.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
