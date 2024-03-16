package com.app.flightnightservices;

import com.app.flightnightservices.configuration.SwingApplicationStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FlightNightServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightNightServicesApplication.class, args);
    }

}
