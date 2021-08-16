package com.example.demo.repositories;

import com.example.demo.model.movies.Movies;
import com.example.demo.model.utils.TimeSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends MongoRepository<Movies,Long>{
    Movies findAllByMoviesName(String tag);
    Movies findAllByTimeSlot(TimeSlot slot);
}
//package com.example.demo.repositories;
//
//        import com.example.demo.model.movies.Movies;
//        import com.example.demo.model.utils.TimeSlot;
//        import org.springframework.data.mongodb.repository.MongoRepository;
//        import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//        import org.springframework.stereotype.Repository;
//
//        import java.util.List;
//
//@Repository
//public interface MoviesRepository extends MongoRepository<Movies,Long> {
//    Movies findAllByMovieName(String movieName);
//    Movies findAllByTag(String tag);
//    Movies findAllByTimeSlot(TimeSlot slot);
//}

