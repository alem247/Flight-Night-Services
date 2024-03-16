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

    public FlightResponse(Flight flight){
        this.id = flight.getId();
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

}
