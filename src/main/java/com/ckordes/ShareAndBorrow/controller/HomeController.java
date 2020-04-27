package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.entity.Address;
import com.ckordes.ShareAndBorrow.entity.Role;
import com.ckordes.ShareAndBorrow.entity.Tool;
import com.ckordes.ShareAndBorrow.entity.User;
import com.ckordes.ShareAndBorrow.repository.AddressRepository;
import com.ckordes.ShareAndBorrow.repository.ToolRepository;
import com.ckordes.ShareAndBorrow.repository.UserRepository;
import com.ckordes.ShareAndBorrow.repository.RoleRepository;
import com.ckordes.ShareAndBorrow.service.UserService;
import com.ckordes.ShareAndBorrow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ToolRepository toolRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public HomeController(BCryptPasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    private UserServiceImpl userServiceImpl;

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
            model.addAttribute("error","Password doesn't match. Please type in password correctly.");
            return "register";
        }
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "User name already exists in database, please select another user name.");
            return "register";

        } else if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email address already exists in database, please provide another email address.");
            return "register";
        }
        httpSession.setAttribute("userRegister",user);
        model.addAttribute("userRegister",user);
        return "redirect:/address";

    }

    @GetMapping("/address")
    public String registerAddress(Model model){
        model.addAttribute("addressRegister", new Address());
        return "registerAddress";
    }
    @PostMapping("/address")
    public String registerAddress(@ModelAttribute ("addressRegister") @Valid Address address, BindingResult bindingResult, Model model, HttpSession httpSession){
        if (bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            model.addAttribute("violations", objectErrors);
            return "registerAddress";
        }
        User user = (User) httpSession.getAttribute("userRegister");
        address.setUserName(user.getUsername());
        addressRepository.save(address);
        address= addressRepository.findByUserName(user.getUsername());
        user.setAddress(address);
        Tool tool = toolRepository.findById(1);
        List<Tool> toolsList = new ArrayList<>(1);
        toolsList.add(tool);
        user.setTools(toolsList);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
        return "redirect:/login";
    }
}
