package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.model.PassDet;

@Repository
public interface PassDetRepository extends JpaRepository<PassDet, Long>{
    
}