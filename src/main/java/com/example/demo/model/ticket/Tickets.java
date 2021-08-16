package com.example.demo.model.ticket;

import com.example.demo.model.utils.TimeSlot;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Tickets")
public class Tickets {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    Long id;
    @Field("ticket_no")
    Long ticketNo;

    @Field("movie_name")
    String  movieName;

    @Field("price")
    String price;

    @Field("movieSlot")
    TimeSlot timeSlot;

    @Field("amount")
    Integer amount;
    public Tickets() {
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }



    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public TimeSlot getTimeSlot() {
//        return timeSlot;
//    }
//
//    public void setTimeSlot(TimeSlot timeSlot) {
//        this.timeSlot = timeSlot;
//    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketNo=" + ticketNo +
                ", movieName='" + movieName + '\'' +
                ", price='" + price + '\'' +
                ", timeSlot=" +
                '}';
    }
}
