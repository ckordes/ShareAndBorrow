package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;

    private String street;
    private String homeNumber;
    private String flatNumber;
    private String city;
    private String postalCode;
    private String voievodyship;
    private String country;

    public Address() {
    }
    public Address(String street, String homeNumber, String flatNumber, String city, String postalCode,
                   String voievodyship, String country){
        this.street = street;
        this.homeNumber = homeNumber;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.voievodyship = voievodyship;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getVoievodyship() {
        return voievodyship;
    }

    public void setVoievodyship(String voievodyship) {
        this.voievodyship = voievodyship;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
