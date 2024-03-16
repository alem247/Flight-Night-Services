package com.app.flightnightservices.configuration;

import com.app.flightnightservices.FlightBookingApplication;
import com.app.flightnightservices.controller.FlightController;
import com.app.flightnightservices.entity.Flight;

import javax.swing.*;

public class SwingApplicationStarter {

    private static FlightController flightController;
    public static void startGUIApplication() {
        SwingUtilities.invokeLater(() -> {
            FlightBookingApplication flightBookingApplication = new FlightBookingApplication(flightController);
            flightBookingApplication.setVisible(true);
        });
    }
}
