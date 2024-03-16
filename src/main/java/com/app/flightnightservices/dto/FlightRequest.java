package com.app.flightnightservices.dto;


import com.app.flightnightservices.entity.Flight;
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
public class FlightRequest {

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



    public FlightRequest(Flight flight){
        this.flightNumber = flight.getFlightNumber();
        this.originAirport = flight.getOriginAirport();
        this.destinationAirport = flight.getDestinationAirport();
        this.carrier = flight.getCarrier();
        this.price = flight.getPrice();
        this.day = flight.getDay();
        this.time = flight.getTime();
        this.duration = flight.getDuration();
        this.availableSeats = flight.getAvailableSeats();
    }

    public FlightRequest(int id, int seats) {
    }

    public FlightRequest(String flightNumber, String originAirport, String destinationAirport, String carrier, double price, LocalDate day, LocalTime time, int numberOfSeats) {

    }
}
