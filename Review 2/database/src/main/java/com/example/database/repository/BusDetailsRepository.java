package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.BusDetails;

public interface BusDetailsRepository extends JpaRepository<BusDetails,Long> {

    
} 