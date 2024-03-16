package com.app.flightnightservices.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwingApplicationConfig {

    @Bean
    public SwingApplicationStarter swingApplicationStarter() {
        return new SwingApplicationStarter();
    }

    @Bean
    public CommandLineRunner initializeGUIOnStartup(SwingApplicationStarter swingApplicationStarter) {
        return args -> swingApplicationStarter.startGUIApplication();
    }
}