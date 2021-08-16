package com.example.demo.controllers;

import com.example.demo.model.movies.Movies;
import com.example.demo.pojo.Search;
import com.example.demo.services.modelServices.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alpha/movies")
public class MoviesControllers {
    @Autowired
    MoviesServices moviesServices;

    @PostMapping("/")
    public String add(@RequestBody Movies movies){
        return moviesServices.add(movies);
    }

    @GetMapping("/all")
    public List<Movies> getAll(){
        return moviesServices.getAll();
    }

    @GetMapping("/list")
    public List<String> getList(){
        return moviesServices.getList();
    }

    @PostMapping("/search")
    public Movies search(@RequestBody Search search){
        return moviesServices.findByName(search.getS());
    }
}
