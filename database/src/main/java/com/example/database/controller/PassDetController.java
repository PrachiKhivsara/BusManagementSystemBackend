package com.example.database.controller;

import java.util.List;

// import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.PassDet;
import com.example.database.service.PassService;




@RestController
@Service
public class PassDetController {
    private PassService passService;
    public PassDetController(PassService passService){
        this.passService = passService;
    }
    @GetMapping("/passengersdetails")
    public List<PassDet> getDetails() {
        return passService.getDetails();
    }
    @GetMapping("/passengers/{id}")
    public ResponseEntity<PassDet> getDetail(@PathVariable Long id) {
        PassDet passDet=passService.getDetail(id);
        if(passDet==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(passDet,HttpStatus.ACCEPTED);
        }
    }
    @PostMapping("/passenger")
    public PassDet postMethodName(@RequestBody PassDet passDet) {
        return passService.addPassenger(passDet);
    }
    @PutMapping("passengers/{id}")
    public ResponseEntity<PassDet> putMethodName(@PathVariable Long id, @RequestBody PassDet passDet) {
        PassDet updatedPassDet = passService.updatePassenger(id, passDet);
        if(updatedPassDet==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPassDet, HttpStatus.OK);
    }
    @DeleteMapping("passengers/{id}")
    public void deletePassenger(@PathVariable Long id){
        passService.deletePassenger(id);
    }
    @GetMapping("/passengersdateofbooking")
    public List<PassDet> getMethodName() {
        return passService.getPassengersBySortDate();
    }

    // @GetMapping("/pagedetails")
    // public Page<PassDet> getPageDetails(@RequestParam int page,@RequestParam int size) {
    //     return passService.getDetailsbyPagination(page,size);
    // }
    
    
}
