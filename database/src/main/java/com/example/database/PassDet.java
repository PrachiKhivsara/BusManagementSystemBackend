package com.example.database;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PassDet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tid;
    
    public Long getTid() {
    return tid;
    }
    public void setTid(Long tid) {
      this.tid = tid;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }
    public String getPhoneNo() {
      return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
      this.phoneNo = phoneNo;
    }
    public String getUser_id() {
      return user_id;
    }
    public void setUser_id(String user_id) {
      this.user_id = user_id;
    }
    public String getFromLocation() {
      return fromLocation;
    }
    public void setFromLocation(String fromLocation) {
      this.fromLocation = fromLocation;
    }
    public String getToLocation() {
      return toLocation;
    }
    public void setToLocation(String toLocation) {
      this.toLocation = toLocation;
    }
    public Date getDate() {
      return date;
    }
    public void setDate(Date date) {
      this.date = date;
    }
    public String getSeatNo() {
      return seatNo;
    }
    public void setSeatNo(String seatNo) {
      this.seatNo = seatNo;
    }
    public String getBusName() {
      return busName;
    }
    public void setBusName(String busName) {
      this.busName = busName;
    }
    private String name;
    private int age;
    private String phoneNo;
    
    private String user_id;
    
    private String fromLocation;
    private String toLocation;
    private Date date;
    private String seatNo;
    private String busName;
}

