package com.example.demo.repositories;

import com.example.demo.model.ticket.Tickets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends MongoRepository<Tickets,Long> {
}
