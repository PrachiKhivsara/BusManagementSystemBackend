package com.example.database.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
