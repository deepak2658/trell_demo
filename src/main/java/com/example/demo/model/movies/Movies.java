package com.example.demo.model.movies;

import com.example.demo.model.utils.TimeSlot;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "movies")
public class Movies {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    Long id;

    @Field("moviesName")
    String moviesName;

    @Field("description")
    String description;

    @Field("duration")
    String duration;

    @Field("time_slot")
    TimeSlot timeSlot;

    @Field("ticketLeft")
    Integer ticketsLeft;


    public Movies() {
    }

    public Movies(Long id, String moviesName, String description, String duration, TimeSlot timeSlot, Integer ticketsLeft) {
        this.id = id;
        this.moviesName = moviesName;
        this.description = description;
        this.duration = duration;
        this.timeSlot = timeSlot;
        this.ticketsLeft = ticketsLeft;
    }


    public String getSequenceName(){
        return SEQUENCE_NAME;
    }
    public Long getId() {
        return id;
    }

    public Integer getTicketsLeft() {
        return ticketsLeft;
    }

    public void setTicketsLeft(Integer ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoviesName() {
        return moviesName;
    }

    public void setMoviesName(String moviesName) {
        this.moviesName = moviesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", moviesName='" + moviesName + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", timeSlot=" + timeSlot +
                ", ticketsLeft=" + ticketsLeft +
                '}';
    }
}
