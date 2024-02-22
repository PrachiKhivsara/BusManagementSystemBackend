package com.example.database.service;

import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.database.PassDet;
import com.example.database.repository.PassDetRepository;

@Service
public class PassService {
    private final PassDetRepository passDetRepository;
    public PassService(PassDetRepository passDetRepository){
        this.passDetRepository = passDetRepository;
    }
    public PassDet addPassenger(PassDet passDet){
        return passDetRepository.save(passDet);
    }
    public List<PassDet> getDetails() {
        return passDetRepository.findAll();
    }
    public PassDet getDetail(Long id) {
        return passDetRepository.findById(id).orElse(null);
    }
    public PassDet updatePassenger(Long id, PassDet passDet){
        PassDet existingPassDet = passDetRepository.findById(id).orElse(null);
        if (existingPassDet == null){
            return null;
        }
        existingPassDet.setName(passDet.getName());
        existingPassDet.setAge(passDet.getAge());
        existingPassDet.setPhoneNo(passDet.getPhoneNo());
        existingPassDet.setUser_id(passDet.getUser_id());
        existingPassDet.setFromLocation(passDet.getFromLocation());
        existingPassDet.setToLocation(passDet.getToLocation());
        existingPassDet.setDate(passDet.getDate());
        return passDetRepository.save(existingPassDet); 
    }
    public void deletePassenger(Long id){
        if(passDetRepository.existsById(id)){
            passDetRepository.deleteById(id);
        }
    }
    public List<PassDet> getPassengersBySortDate(){
        return passDetRepository.findAll(Sort.by(Sort.Direction.DESC,"Date"));
    }
    // public Page<PassDet> getDetailsbyPagination(int page,int size){
    //     return passDetRepository.findAll(PageRequest.of(page,size));
    // }

}
