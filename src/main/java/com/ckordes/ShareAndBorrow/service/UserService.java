package com.ckordes.ShareAndBorrow.service;


import com.ckordes.ShareAndBorrow.entity.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
