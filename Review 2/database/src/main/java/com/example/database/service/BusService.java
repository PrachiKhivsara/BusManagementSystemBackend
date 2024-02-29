package com.example.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.model.BusDetails;
import com.example.database.repository.BusDetailsRepository;

@Service
public class BusService {
    @Autowired
    private BusDetailsRepository busDetailsRepository;

    public BusDetails saveBus(BusDetails bus){
        return busDetailsRepository.save(bus);
    }

    public List<BusDetails> getBuses(){
        return busDetailsRepository.findAll();
    }

    public BusDetails getBus(Long id){
        return busDetailsRepository.findById(id).orElse(null);
    }
}
