package com.example.demo.repositories;

import com.example.demo.model.user.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users,Long> {
    Users findAllByUsername(String username);
}
