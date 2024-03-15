package com.app.flightnightservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String flightNumber;
    private String originAirport;
    private String destinationAirport;
    private String carrier;
    private double price;
    private LocalDate day;
    private LocalTime time;
    private Time duration;
    private int availableSeats;

}
