package com.example.demo.controllers;

import com.example.demo.model.movies.Movies;
import com.example.demo.model.ticket.Tickets;
import com.example.demo.services.modelServices.TicketsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alpha/tickets")
public class TicketsController {
    @Autowired
    TicketsServices ticketsServices;

    @PostMapping("/")
    public String save(@RequestBody Tickets tickets){
        return ticketsServices.save(tickets);
    }

    @GetMapping("all")
    public List<Tickets> getAll(){
        return ticketsServices.getAll();
    }
}
