package com.app.flightnightservices.service;


import com.app.flightnightservices.dto.FlightRequest;
import com.app.flightnightservices.dto.FlightResponse;
import org.springframework.stereotype.Service;
import com.app.flightnightservices.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public interface FlightService {

    void addFlight(FlightRequest flight);
    void deleteFlight(int id);
    void updateFlight(FlightRequest flight);
    FlightResponse getFlightById(int id);
    List<FlightResponse> getAllFlights();
    List<FlightResponse> getFlightsByOrigin(String origin);
    List<FlightResponse> getFlightsByDestination(String destination);
    List<FlightResponse> getFlightsByCarrier(String carrier);
    List<FlightResponse> getFlightsByDay(LocalDate day);
    List<FlightResponse> getFlightsByTime(LocalTime time);
    List<FlightResponse> getFlightsByPrice(double price);
    List<FlightResponse> getFlightsByAvailableSeats(int availableSeats);
    List<FlightResponse> getFlightsByOriginAndDestination(String origin, String destination);
    List<FlightResponse> getFlightsByOriginAndCarrier(String origin, String carrier);
}
