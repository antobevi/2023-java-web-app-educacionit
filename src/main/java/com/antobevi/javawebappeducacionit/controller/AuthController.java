package com.antobevi.javawebappeducacionit.controller;

import com.antobevi.javawebappeducacionit.model.User;
import com.antobevi.javawebappeducacionit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String getSignUpForm(Model model) {
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(User user) {
        userService.saveUser(user);

        return "redirect:/login";
    }

}