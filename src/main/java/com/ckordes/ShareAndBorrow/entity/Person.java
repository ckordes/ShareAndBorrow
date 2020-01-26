package com.ckordes.ShareAndBorrow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String login;
    private Address address;
    private Tool tools;

}
