package com.luck.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luck.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
