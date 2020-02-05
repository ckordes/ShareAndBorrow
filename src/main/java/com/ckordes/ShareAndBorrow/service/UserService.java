package com.ckordes.ShareAndBorrow.service;


import com.ckordes.ShareAndBorrow.entity.User;

public interface UserService {
        User findByEmail (String email);
        void saveUser(User user);
    }
