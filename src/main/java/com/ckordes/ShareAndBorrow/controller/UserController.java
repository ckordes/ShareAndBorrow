package com.ckordes.ShareAndBorrow.controller;

import com.ckordes.ShareAndBorrow.entity.*;
import com.ckordes.ShareAndBorrow.repository.AddressRepository;
import com.ckordes.ShareAndBorrow.repository.ToolRepository;
import com.ckordes.ShareAndBorrow.repository.ToolTypeRepository;
import com.ckordes.ShareAndBorrow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private ToolTypeRepository toolTypeRepository;

    @ModelAttribute("ToolTypeList")
    public List<ToolType> allToolTypes() {
        return toolTypeRepository.findAll();
    }

    @ModelAttribute("allUsersList")
    public List<User> allUsersList() {
        return userRepository.findAll();
    }

    @GetMapping("/changePassword")
    public String changeUserInfo(Model model, Authentication authentication) {
        User user = new User();
        String userName = authentication.getName();
        user = userRepository.findByUsername(userName);
        UserCredentialsModifications userCredentialsModifications = new UserCredentialsModifications("", "", user.getEmail());
        model.addAttribute("userCredentialsModifications", userCredentialsModifications);
        return "/changePassword";
    }

    @PostMapping("/changePassword")
    public String changeUserInfo(@ModelAttribute @Valid UserCredentialsModifications userCredentialsModifications, BindingResult bindingResult, Authentication authentication, Model model) {
        if (bindingResult.hasErrors()) {
            return "/changePassword";
        }
        if (!userCredentialsModifications.checkPasswordsEqual()) {
            String errorMsg = "Passwords don't match! Please insert again correct passwords!";
            model.addAttribute("errorMsg", errorMsg);
            return "/changePassword";
        }
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(userCredentialsModifications.getEmail()));
        if (optionalUser.isPresent()) {
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
    public String changeUserAddress(Model model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Address address = user.getAddress();
        model.addAttribute("userAddress", address);
        return "/changeAddress";
    }

    @PostMapping("/changeAddress")
    public String changeUserAddress(@ModelAttribute("userAddress") @Valid Address userAddress, BindingResult bindingResult, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "/changeAddress";
        }
        Address addressInDB = addressRepository.findByUserName(authentication.getName());
        addressInDB = userAddress;
        addressRepository.save(addressInDB);
        return "redirect:/";
    }

    @GetMapping("/addTool")
    public String addToolToUser(Model model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Tool tool = new Tool();
        model.addAttribute("addTool", tool);
        return "/addTool";
    }

    @PostMapping("/addTool")
    public String addToolToUser(@ModelAttribute("addTool") @Valid Tool addTool, BindingResult bindingResult, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "/addTool";
        }
        User user = userRepository.findByUsername(authentication.getName());
        addTool.setUserID(user.getId());
        toolRepository.save(addTool);
        List<Tool> userTools = toolRepository.findAllByUserID(user.getId());
        Long lastTool = userTools.stream().mapToLong(Tool::getId).max().orElseThrow(NoSuchElementException::new);
        Optional<Tool> toolOptional = toolRepository.findById(lastTool);
        if (toolOptional.isPresent()) {
            Tool toolToAdd = toolOptional.get();
            user.getTools().add(toolToAdd);
            userRepository.save(user);
        }
        return "redirect:/user/toolsManagement";
    }

    @GetMapping("/toolsManagement")
    public String toolsManagement(Model model, Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName());
        List<Tool> toolList = toolRepository.findAllByUserID(user.getId());
        model.addAttribute("toolList",toolList);

        return "/toolsManagement";
    }

    @GetMapping("/deleteTool/{id}")
    public String deleteTool(@PathVariable long id, Authentication authentication){
        Tool tool = toolRepository.findById(id);
        User user = userRepository.findByUsername(authentication.getName());
        user.getTools().remove(tool);
        toolRepository.delete(tool);
        return "redirect:/user/toolsManagement";
    }

    @GetMapping("/editTool/{id}")
    public String editTool(@PathVariable long id, Model model){
        Tool tool = toolRepository.findById(id);
        model.addAttribute("tool",tool);
        return "/editTool";

    }

    @PostMapping("/editTool/{id}")
    public String editTool( @ModelAttribute @Valid Tool tool, BindingResult bindingResult, @PathVariable long id){
        if (bindingResult.hasErrors()){
            return "/editTool";
        }
        toolRepository.save(tool);
        return "redirect:/user/toolsManagement";
    }

    @RequestMapping("/userZone")
    public String userZone(){
        return "/userZone";
    }

    @GetMapping ("/searchTool")
    public String searchTool(Model model){
        ToolType toolType = new ToolType();
        String postalCode="00-000";
        model.addAttribute("toolType",toolType);
        model.addAttribute("postalCode",postalCode);
        return "/searchTool";
    }
//    @PostMapping("/searchTool")
//    public String searchTool(@ModelAttribute ToolType toolTypeFromList, Model model ){
//        List<Tool> toolList = toolRepository.findByToolTypeId(toolTypeFromList.getId());
//        model.addAttribute("toolList",toolList);
//    }



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

    //x-> tool.getid
    //Tool::getId


}
