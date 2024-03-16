package com.app.flightnightservices.configuration;

import com.app.flightnightservices.FlightBookingApplication;
import com.app.flightnightservices.controller.FlightController;
import com.app.flightnightservices.entity.Flight;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class SwingApplicationStarter {

    private static FlightController flightController;
    public  void startGUIApplication() {
        SwingUtilities.invokeLater(() -> {
            FlightBookingApplication flightBookingApplication = new FlightBookingApplication(flightController);
            flightBookingApplication.setVisible(true);
        });
    }
}
