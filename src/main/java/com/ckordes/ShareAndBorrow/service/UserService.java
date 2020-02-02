package com.ckordes.ShareAndBorrow.service;


import com.ckordes.ShareAndBorrow.entity.Person;

public interface UserService {
        Person findPersonByEmail(String email);
        void saveUser(Person person);
    }
