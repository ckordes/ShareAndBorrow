package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.entity.Tool;
import com.ckordes.ShareAndBorrow.entity.User;
import com.ckordes.ShareAndBorrow.repository.UserRepository;
import com.ckordes.ShareAndBorrow.repository.RoleRepository;
import com.ckordes.ShareAndBorrow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @RequestMapping("/")
    public String homeAction (Model model) { return "index";}

    @GetMapping("/register")
    public String registerUser(Model model) {
        User user = new User();
        model.addAttribute("userRegister", user);
        model.addAttribute("password2", "");
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserN(@ModelAttribute("userRegister") @Valid User user, BindingResult bindingResult, @ModelAttribute("password2") String password2, Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            model.addAttribute("violations", objectErrors);
            return "register";
        }
        if (!user.getPassword().equals(password2)) {
            return "register";
        }
        if (userService.findByUserName(user.getUsername()) != null) {
            model.addAttribute("error", "User name already exists in database, please select another user name.");
            return "register";

        } else if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email address already exists in database, please provide another email address.");
            return "register";
        }
        return "register";

    }

    @GetMapping("/tool")
    public String toolCreation(Model model){
        Tool tool = new Tool();
        model.addAttribute("toolC",tool);
        return "tool";
    }
    @PostMapping("/tool")
    public String toolCreate(@ModelAttribute ("toolC") Tool toolC){
        return "redirect:/";
    }

}
