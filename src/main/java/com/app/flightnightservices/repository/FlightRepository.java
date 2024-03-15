package com.app.flightnightservices.repository;


import com.app.flightnightservices.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByOriginAirport(String originAirport);
    List<Flight> findByDestinationAirport(String destinationAirport);
    List<Flight> findByCarrier(String carrier);
    List<Flight> findByDay(LocalDate day);
    List<Flight> findByTime(LocalTime time);
    List<Flight> findByDuration(Time duration);
    List<Flight> findByPrice(double price);
    List<Flight> findByAvailableSeats(int availableSeats);
    List<Flight> findByOriginAirportAndDestinationAirport(String originAirport, String destinationAirport);
    List<Flight> findByOriginAirportAndCarrier(String originAirport, String carrier);

}
