package com.app.flightnightservices.entity;

import com.app.flightnightservices.dto.FlightResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


    public Flight(FlightResponse flightResponse) {

    }
}
