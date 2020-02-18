package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.entity.User;
import com.ckordes.ShareAndBorrow.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin@admin.com");
        user.setPassword("admin");
        user.setPesel("88080811122");
        userService.saveUser(user);
        return "admin";
    }
}
