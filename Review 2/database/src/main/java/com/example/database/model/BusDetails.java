package com.example.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BusDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long busid;
    private String name;
    private String nameplateNumber;
    public BusDetails() {}

    public Long getBusid() {
        return busid;
    }

    public void setBusid(Long busid) {
        this.busid = busid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameplateNumber() {
        return nameplateNumber;
    }

    public void setNameplateNumber(String nameplateNumber) {
        this.nameplateNumber = nameplateNumber;
    }

}
