package com.example.demo.services.modelServices;

import com.example.demo.model.Movie;
import com.example.demo.model.movies.Movies;
import com.example.demo.repositories.MovieRepository;
import com.example.demo.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServices {

    @Autowired
    MovieRepository movieRepository;

    @Transactional
    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    @Transactional
    public String add(Movie movie){
        try{
            Movie movie1 =null;
             movie1=       movieRepository.findAllByMoviesName(movie.getMoviesName());
             if(movie1!=null) return "movie already exists";
             else {
                 movieRepository.save(movie);
                 return movie.toString();
             }
        }catch (Exception e) {
            return  e.toString();
        }
    }
}
