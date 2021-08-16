package com.example.demo.repositories;

import com.example.demo.pojo.DbSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbSequenceRepository extends MongoRepository<DbSequence,Long> {
}
