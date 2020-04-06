package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.entity.User;
import com.ckordes.ShareAndBorrow.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("aa");
        user.setPassword("aa");
        user.setEmail("aa@aa.com");
        user.setPesel("88080811333");
        userService.saveUser(user);
        return "login";
    }


}
