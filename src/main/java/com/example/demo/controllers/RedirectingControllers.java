package com.example.demo.controllers;

import com.example.demo.services.modelServices.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("alpha/home")
public class RedirectingControllers {
    @Autowired
    MoviesServices moviesServices;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/search")
    public String search(Model model){
        List<String> list = moviesServices.getList();
        model.addAttribute("list",list);
        return "SearchMovies";
    }
    @GetMapping("signup")
    public String signup(){
        return "signup";
    }
}
