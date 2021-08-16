package com.example.demo.services.modelServices;

import com.example.demo.model.movies.Movies;
import com.example.demo.model.ticket.Tickets;
import com.example.demo.repositories.TicketsRepository;
import com.example.demo.services.DbSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.model.movies.Movies.SEQUENCE_NAME;

@Service
public class TicketsServices {

    @Autowired
    TicketsRepository ticketsRepository;
    @Autowired
    DbSequenceService dbSequenceService;
    @Autowired
    MoviesServices moviesServices;


    public String save(Tickets tickets){
        tickets.setId((long)dbSequenceService.getSequenceNumber(SEQUENCE_NAME));

        Movies m = null;
        m = moviesServices.findByName(tickets.getMovieName());

        if(m.getTicketsLeft()-tickets.getAmount()<0){
            return "tickets sold out only "+m.getTicketsLeft()+" left.";
        }
        m.setTicketsLeft(m.getTicketsLeft()-tickets.getAmount());
        moviesServices.update(m);
        ticketsRepository.save(tickets);
        return tickets.toString();
//        try {
//
//
//        }catch (Exception e) {
//            return e.toString();
//        }
    }

    @Transactional
    public List<Tickets> getAll(){
        return ticketsRepository.findAll();
    }

}
