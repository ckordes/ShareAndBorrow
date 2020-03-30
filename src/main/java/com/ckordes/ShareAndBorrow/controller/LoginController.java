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

//    @PostMapping("/login")
//    public String homePageAfterLogin() {
//        return "redirect:/";
//    }

//    @PostMapping("/login")
//    public String homePageAfterLogin() {
//        return "/";
//    }


//    public String login(@RequestParam(required = false) String error, Model model) {
//        if (error != null) {
//            model.addAttribute("loginError", "Błędny e-mail lub hasło");
//        }
//        return "/";
//    }
//


//        ModelAndView modelAndView = new ModelAndView();
//        if (error != null) {
//            modelAndView.setViewName("403");
//        } else modelAndView.setViewName("login");
//
//        return modelAndView;
////        return "login";

//    @PostMapping(value = "/login")
//    public String login(@ModelAttribute("loginMode") LoginMode loginMode) {
//
//        return "redirect:/";
//
//
//    }
}
