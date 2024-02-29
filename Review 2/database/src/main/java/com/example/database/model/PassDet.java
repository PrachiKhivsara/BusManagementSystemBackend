package com.example.database.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String fromLocation;
    private String toLocation;
    private Date date;
    private String seatNo;
    private String busName;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "busid", nullable = false)
    // private BusDetails busDetails;
    public PassDet() {
    }
}

