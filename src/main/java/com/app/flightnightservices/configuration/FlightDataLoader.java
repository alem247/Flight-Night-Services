package com.app.flightnightservices.configuration;

import com.app.flightnightservices.entity.Flight;
import com.app.flightnightservices.repository.FlightRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class FlightDataLoader {

    @Autowired
    private FlightRepository flightRepository;

    @PostConstruct
    @Transactional
    public void loadFlights() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("src/main/resources/flights.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\\^");
            Flight flight = new Flight();
            flight.setFlightNumber(data[0]);
            flight.setOriginAirport(data[1]);
            flight.setDestinationAirport(data[2]);
            flight.setCarrier(data[3]);
            flight.setPrice(Double.parseDouble(data[4]));
            flight.setDay(LocalDate.parse(data[5]));
            flight.setTime(LocalTime.parse(data[6]));
            flight.setDuration(Time.valueOf(data[7]));
            flight.setAvailableSeats(Integer.parseInt(data[8]));
            flightRepository.save(flight);
        }

        reader.close();
    }
}