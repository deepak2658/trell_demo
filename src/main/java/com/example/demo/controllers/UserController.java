package com.example.demo.controllers;

import com.example.demo.model.user.Users;
import com.example.demo.pojo.Login;
import com.example.demo.services.modelServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alpha/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public String save(@RequestBody Users users){
         return userService.save(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login){
        if(userService.login(login)!=1) return "login UnSuccessful";
        else return "login successful";
    }
}
