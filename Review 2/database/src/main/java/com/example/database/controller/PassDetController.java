package com.example.database.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.model.BusDetails;
import com.example.database.model.PassDet;
import com.example.database.model.User;
import com.example.database.service.BusService;
import com.example.database.service.PassService;
import com.example.database.service.UserService;






@RestController
@Service
public class PassDetController {
    private PassService passService;
    private UserService userService;
    private BusService busService;
    public PassDetController(PassService passService,UserService userService,BusService busService){
        this.passService = passService;
        this.userService = userService;
        this.busService = busService;
    }
    @PostMapping("/passenger")
    public PassDet postMethodName(@RequestBody PassDet passDet) {
        return passService.addPassenger(passDet);
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
            return new ResponseEntity<>(passDet,HttpStatus.OK);
        }
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
    @GetMapping("/passengerdetails/{sort}")
    public List<PassDet> getOldest(@PathVariable String sort) {
        return passService.getPassengersBySortDate(sort);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @PostMapping("/user")
    public ResponseEntity<User> postMethodName1(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/pagedetails")
    public List<PassDet> getPageDetails(@RequestParam(name="pageNo") int page) {
        return passService.getDetailsbyPagination(page-1).getContent();
    }
    
    @GetMapping("/passenger/{username}")
    public List<PassDet> getPassengerByUsername(@PathVariable String username) {
        return userService.getPassengerByUserName(username);
    }


    @PostMapping("/busdetails")
    public BusDetails postBusDetails(@RequestBody BusDetails busDetails) {
        return busService.saveBus(busDetails);
    }
    @GetMapping("/busdetails")
    public List<BusDetails> getBusDetails(@RequestBody BusDetails busDetails) {
        return busService.getBuses();
    }
    
}
