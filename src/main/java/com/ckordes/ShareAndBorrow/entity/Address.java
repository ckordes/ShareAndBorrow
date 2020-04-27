package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String street;
    @NotBlank
    private String homeNumber;
    @NotBlank
    private String flatNumber;
    @NotBlank
    private String city;
    @NotBlank
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}",message = "Zip code format should be 00-000, please correct it accordingly!")
    private String postalCode;
    @NotBlank
    private String voievodyship;
    @NotBlank
    private String country;
    @NotBlank
    private String userName;

    public Address() {
    }

    public Address(String street, String homeNumber, String flatNumber, String city, String postalCode,
                   String voievodyship, String country, String userName) {
        this.street = street;
        this.homeNumber = homeNumber;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.voievodyship = voievodyship;
        this.country = country;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
