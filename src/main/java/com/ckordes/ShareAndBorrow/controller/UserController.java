package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.entity.Address;
import com.ckordes.ShareAndBorrow.entity.User;
import com.ckordes.ShareAndBorrow.entity.UserCredentialsModifications;
import com.ckordes.ShareAndBorrow.repository.AddressRepository;
import com.ckordes.ShareAndBorrow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @ModelAttribute("allUsersList")
    public List<User> allUsersList(){
        return userRepository.findAll();
    }

    @GetMapping("/changePassword")
    public String changeUserInfo(Model model, Authentication authentication) {
        User user = new User();
        String userName = authentication.getName();
        user = userRepository.findByUsername(userName);
        UserCredentialsModifications userCredentialsModifications= new UserCredentialsModifications("","",user.getEmail());
        model.addAttribute("userCredentialsModifications",userCredentialsModifications);
        return "/changePassword";
    }

    @PostMapping("/changePassword")
    public String changeUserInfo(@ModelAttribute @Valid UserCredentialsModifications userCredentialsModifications, BindingResult bindingResult, Authentication authentication, Model model) {
        if (bindingResult.hasErrors()){
            return "/changePassword";
        }
        if (!userCredentialsModifications.checkPasswordsEqual()) {
            String errorMsg = "Passwords don't match! Please insert again correct passwords!";
            model.addAttribute("errorMsg",errorMsg);
            return "/changePassword";
        }
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(userCredentialsModifications.getEmail()));
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (!authentication.getName().equals(user.getUsername())) {
                String errorMsg = "Given e-mail already exists!" + "/n" + "Please provide new e-mail!";
                model.addAttribute("errorMsg", errorMsg);
                return "/changePassword";
            }
        }
        User user = new User();
        user = userRepository.findByUsername(authentication.getName());
        user.setEmail(userCredentialsModifications.getEmail());
        String newPassword = userCredentialsModifications.getPassword();
        user.setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/changeAddress")
    public String changeUserAddress(Model model, Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName());
        Address address = user.getAddress();
        model.addAttribute("userAddress",address);
        return "/changeAddress";
    }
    @PostMapping("/changeAddress")
    public String changeUserAddress(@ModelAttribute ("userAddress")  @Valid Address userAddress, BindingResult bindingResult,Authentication authentication){
        if(bindingResult.hasErrors()){
            return "/changeAddress";
        }
        Address addressInDB = addressRepository.findByUserName(authentication.getName());
        addressInDB = userAddress;
        addressRepository.save(addressInDB);
        return "redirect:/";
    }

//    @GetMapping("/create-user")
//    @ResponseBody
//    public String createUser() {
//        User user = new User();
//        user.setUsername("aa");
//        user.setPassword("aa");
//        user.setEmail("aa@aa.com");
//        user.setPesel("88080811333");
//        userService.saveUser(user);
//        return "login";
//    }



}
