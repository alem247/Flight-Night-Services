package com.app.flightnightservices.service.impl;


import com.app.flightnightservices.dto.FlightRequest;
import com.app.flightnightservices.dto.FlightResponse;
import com.app.flightnightservices.entity.Flight;
import com.app.flightnightservices.repository.FlightRepository;
import com.app.flightnightservices.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void addFlight(FlightRequest flight) {
        Flight newFlight = new Flight();
        newFlight.setFlightNumber(flight.getFlightNumber());
        newFlight.setOriginAirport(flight.getOriginAirport());
        newFlight.setDestinationAirport(flight.getDestinationAirport());
        newFlight.setCarrier(flight.getCarrier());
        newFlight.setPrice(flight.getPrice());
        newFlight.setDay(flight.getDay());
        newFlight.setTime(flight.getTime());
        newFlight.setDuration(flight.getDuration());
        newFlight.setAvailableSeats(flight.getAvailableSeats());
        flightRepository.save(newFlight);
    }

    @Override
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public void updateFlight(FlightRequest flight) {
        Flight updatedFlight = flightRepository.findById(flight.getId()).get();
        flight.setFlightNumber(flight.getFlightNumber());
        flight.setOriginAirport(flight.getOriginAirport());
        flight.setDestinationAirport(flight.getDestinationAirport());
        flight.setCarrier(flight.getCarrier());
        flight.setPrice(flight.getPrice());
        flight.setDay(flight.getDay());
        flight.setTime(flight.getTime());
        flight.setDuration(flight.getDuration());
        flight.setAvailableSeats(flight.getAvailableSeats());
        flightRepository.save(updatedFlight);

    }

    @Override
    public FlightResponse getFlightById(int id) {
        Flight flight = flightRepository.findById(id).get();
        return new FlightResponse(flight.getId(), flight.getFlightNumber(), flight.getOriginAirport(),
                flight.getDestinationAirport(), flight.getCarrier(), flight.getPrice(), flight.getDay(),
                flight.getTime(), flight.getDuration(), flight.getAvailableSeats());
    }

    public List<Flight> unpackListOfFlightResponses(List<FlightResponse> flightResponses) {
         return flightResponses.stream().map(flightResponse -> new Flight(flightResponse.getId(), flightResponse.getFlightNumber(), flightResponse.getOriginAirport(),
                flightResponse.getDestinationAirport(), flightResponse.getCarrier(), flightResponse.getPrice(), flightResponse.getDay(),
                flightResponse.getTime(), flightResponse.getDuration(), flightResponse.getAvailableSeats())).collect(Collectors.toList());
    }

    public List<Flight> unpackListOfFlightRequests(List<FlightRequest> flightRequests) {
        return flightRequests.stream().map(flightRequest -> new Flight(flightRequest.getId(), flightRequest.getFlightNumber(), flightRequest.getOriginAirport(),
                flightRequest.getDestinationAirport(), flightRequest.getCarrier(), flightRequest.getPrice(), flightRequest.getDay(),
                flightRequest.getTime(), flightRequest.getDuration(), flightRequest.getAvailableSeats())).collect(Collectors.toList());
    }

    public List<FlightResponse> packListOfFlightsToFlightResponses(List<Flight> flights) {
        return flights.stream().map(flight -> new FlightResponse(flight.getId(), flight.getFlightNumber(), flight.getOriginAirport(),
                flight.getDestinationAirport(), flight.getCarrier(), flight.getPrice(), flight.getDay(),
                flight.getTime(), flight.getDuration(), flight.getAvailableSeats())).collect(Collectors.toList());
    }

    public List<FlightRequest> packListOfFlightsToFlightRequests(List<Flight> flights) {
        return flights.stream().map(flight -> new FlightRequest(flight.getId(), flight.getFlightNumber(), flight.getOriginAirport(),
                flight.getDestinationAirport(), flight.getCarrier(), flight.getPrice(), flight.getDay(),
                flight.getTime(), flight.getDuration(), flight.getAvailableSeats())).collect(Collectors.toList());
    }


    @Override
    public List<FlightResponse> getAllFlights() {
        return packListOfFlightsToFlightResponses(flightRepository.findAll());
    }

    @Override
    public List<FlightResponse> getFlightsByOrigin(String origin) {
        return packListOfFlightsToFlightResponses(flightRepository.findByOriginAirport(origin));
    }

    @Override
    public List<FlightResponse> getFlightsByDestination(String destination) {
        return packListOfFlightsToFlightResponses(flightRepository.findByDestinationAirport(destination));
    }

    @Override
    public List<FlightResponse> getFlightsByCarrier(String carrier) {
        return packListOfFlightsToFlightResponses(flightRepository.findByCarrier(carrier));
    }

    @Override
    public List<FlightResponse> getFlightsByDay(LocalDate day) {
        return packListOfFlightsToFlightResponses(flightRepository.findByDay(day));
    }

    @Override
    public List<FlightResponse> getFlightsByTime(LocalTime time) {
        return packListOfFlightsToFlightResponses(flightRepository.findByTime(time));
    }

    @Override
    public List<FlightResponse> getFlightsByPrice(double price) {
        return packListOfFlightsToFlightResponses(flightRepository.findByPrice(price));
    }

    @Override
    public List<FlightResponse> getFlightsByAvailableSeats(int availableSeats) {
        return packListOfFlightsToFlightResponses(flightRepository.findByAvailableSeats(availableSeats));
    }

    @Override
    public List<FlightResponse> getFlightsByOriginAndDestination(String origin, String destination) {
        return packListOfFlightsToFlightResponses(flightRepository.findByOriginAirportAndDestinationAirport(origin, destination));
    }

    @Override
    public List<FlightResponse> getFlightsByOriginAndCarrier(String origin, String carrier) {
        return packListOfFlightsToFlightResponses(flightRepository.findByOriginAirportAndCarrier(origin, carrier));
    }
}
