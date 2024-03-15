package com.app.flightnightservices.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {

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