package com.ckordes.ShareAndBorrow.service;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
