package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.repository.UserRepository;
import com.ckordes.ShareAndBorrow.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String homeAction (Model model) { return "index";}
}
