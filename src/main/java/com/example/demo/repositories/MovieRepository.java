package com.example.demo.repositories;

import com.example.demo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Long> {
    Movie findAllByMoviesName(String string);
}
