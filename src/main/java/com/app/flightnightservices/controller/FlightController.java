package com.app.flightnightservices.controller;


import com.app.flightnightservices.dto.FlightRequest;
import com.app.flightnightservices.dto.FlightResponse;
import com.app.flightnightservices.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/addFlight")
    public void addFlight(@RequestBody FlightRequest flightRequest) {
        flightService.addFlight(flightRequest);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public void deleteFlight(@PathVariable("id") int id) {
        flightService.deleteFlight(id);
    }

    @PostMapping("/updateFlight")
    public void updateFlight(@RequestBody FlightRequest flightRequest) {
        flightService.updateFlight(flightRequest);
    }

    @GetMapping("/getFlightById/{id}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable("id") int id) {
        FlightResponse flight = flightService.getFlightById(id);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllFlights")
    public List<FlightResponse> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/getFlightsByOrigin")
    public List<FlightResponse> getFlightsByOrigin(@RequestParam String origin) {
        return flightService.getFlightsByOrigin(origin);
    }

    @GetMapping("/getFlightsByDestination")
    public List<FlightResponse> getFlightsByDestination(@RequestParam String destination) {
        return flightService.getFlightsByDestination(destination);
    }

    @GetMapping("/getFlightsByCarrier")
    public List<FlightResponse> getFlightsByCarrier(@RequestParam String carrier) {
        return flightService.getFlightsByCarrier(carrier);
    }

    @GetMapping("/getFlightsByDay")
    public List<FlightResponse> getFlightsByDay(@RequestParam LocalDate day) {
        return flightService.getFlightsByDay(day);
    }

    @GetMapping("/getFlightsByTime")
    public List<FlightResponse> getFlightsByTime(@RequestParam LocalTime time) {
        return flightService.getFlightsByTime(time);
    }

    @GetMapping("/getFlightsByPrice")
    public List<FlightResponse> getFlightsByPrice(@RequestParam double price) {
        return flightService.getFlightsByPrice(price);
    }

}
