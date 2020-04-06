package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.entity.LoginMode;
import com.ckordes.ShareAndBorrow.entity.User;
import com.ckordes.ShareAndBorrow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, @RequestParam(required = false) String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("userRegister", new User());
        return "register";
    }
}
