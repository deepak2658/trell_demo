package com.example.demo.controllers;

import com.example.demo.model.Movie;
import com.example.demo.services.modelServices.MovieServices;
import com.example.demo.services.modelServices.MoviesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alpha/movie")
public class MovieController {
    @Autowired
    MovieServices moviesServices;

    @GetMapping("/all")
    public List<Movie> getall(){
        return moviesServices.getAll();
    }
    @PostMapping("/")
public String save(@RequestBody Movie movie){
        return moviesServices.add(movie);
    }
}
