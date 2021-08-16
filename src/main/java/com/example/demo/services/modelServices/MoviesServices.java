package com.example.demo.services.modelServices;

import com.example.demo.model.movies.Movies;
import com.example.demo.repositories.MoviesRepository;
import com.example.demo.services.DbSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.model.movies.Movies.SEQUENCE_NAME;

@Service
public class MoviesServices {
    @Autowired
    MoviesRepository moviesRepository;
    @Autowired
    DbSequenceService dbSequenceService;

    @Transactional
    public String add(Movies movies){
        try {
            Movies temp  = null;
//            temp = moviesRepository.findAllByMovieName(movies.getMovieName());
            if(temp!=null){
                return "Cant add a movie, movie already exists";
            }
            temp = null;
            temp = moviesRepository.findAllByTimeSlot(movies.getTimeSlot());
            if(temp!=null) return "Slot not free";
            movies.setId((long)dbSequenceService.getSequenceNumber(SEQUENCE_NAME));
            moviesRepository.save(movies);
            return movies.toString();
        }catch (Exception e){
            return e.toString();
        }
    }

    @Transactional
    public List<Movies> getAll(){
        List<Movies> moviesList = moviesRepository.findAll();
        return moviesList;
    }

    @Transactional
    public List<String> getList(){
            List<Movies> moviesList = moviesRepository.findAll();
            List<String> finalList = new ArrayList<>();
            for (Movies m :moviesList){
                finalList.add(m.getMoviesName());
            }
            return finalList;
    }
//    @Transactional
//    public String search(Search search){
//        Movies  movies = null;
//
//          movies=  moviesRepository.findAllByMovieName(search.getS());
//
//        if (movies==null) return "Not found";
//        else return "Movie found";
//    }
    @Transactional
    public Movies findByName(String name){
        return moviesRepository.findAllByMoviesName(name);
    }

    @Transactional
    public Movies update(Movies movies){
        return moviesRepository.save(movies);
    }
}
