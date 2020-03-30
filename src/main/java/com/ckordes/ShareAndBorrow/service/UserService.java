package com.ckordes.ShareAndBorrow.service;


import com.ckordes.ShareAndBorrow.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
