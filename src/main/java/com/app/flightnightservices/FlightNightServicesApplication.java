package com.app.flightnightservices;

import com.app.flightnightservices.configuration.SwingApplicationStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightNightServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightNightServicesApplication.class, args);
    }

    @Bean
    public SwingApplicationStarter swingApplicationStarter() {
        return new SwingApplicationStarter();
    }

    @Bean
    public void initializeGUIOnStartup(SwingApplicationStarter swingApplicationStarter) {
        swingApplicationStarter.startGUIApplication();
    }

}
