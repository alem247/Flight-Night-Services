package com.app.flightnightservices;

import com.app.flightnightservices.dto.FlightRequest;
import com.app.flightnightservices.dto.FlightResponse;
import com.app.flightnightservices.entity.Flight;
import com.app.flightnightservices.repository.FlightRepository;
import com.app.flightnightservices.service.FlightService;
import com.app.flightnightservices.service.impl.FlightServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.app.flightnightservices.controller.FlightController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FlightBookingApplication extends JFrame {

    private final FlightController flightController;

    private JComboBox<String> originComboBox;
    private JComboBox<String> destinationComboBox;
    private JTable flightsTable;
    private DefaultTableModel tableModel;
    private JTextField seatsTextField;
    private JButton searchButton;
    private JButton bookButton;
    private JLabel messageLabel;

    private void initComponents() {
        originComboBox = new JComboBox<>();
        destinationComboBox = new JComboBox<>();
        seatsTextField = new JTextField(5);
        searchButton = new JButton("Search");
        bookButton = new JButton("Book");
        messageLabel = new JLabel();

        searchButton.addActionListener(e -> searchFlights());
        bookButton.addActionListener(e -> bookFlight());

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Flight Number", "Origin", "Destination", "Carrier", "Price", "Day", "Time", "Duration", "Available Seats"});
        flightsTable = new JTable(tableModel);
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Origin:"));
        panel.add(originComboBox);
        panel.add(new JLabel("Destination:"));
        panel.add(destinationComboBox);
        panel.add(searchButton);
        return panel;
    }

    private JPanel createFlightsPanel() {
        JScrollPane scrollPane = new JScrollPane(flightsTable);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createBookingPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Seats:"));
        panel.add(seatsTextField);
        panel.add(bookButton);
        panel.add(messageLabel);
        return panel;
    }

    public FlightBookingApplication(FlightController flightController) {

        this.flightController = flightController;

        setTitle("Flight Booking Application");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initComponents();

        add(createSearchPanel(), BorderLayout.NORTH);
        add(createFlightsPanel(), BorderLayout.CENTER);
        add(createBookingPanel(), BorderLayout.SOUTH);

        loadFlights();
    }

    private void loadFlights() {
        List<FlightResponse> flights = flightController.getAllFlights();
        for (FlightResponse flight : flights) {
            tableModel.addRow(new Object[]{flight.getFlightNumber(), flight.getOriginAirport(), flight.getDestinationAirport(), flight.getCarrier(),
                    flight.getPrice(), flight.getDay(), flight.getTime(), flight.getDuration(), flight.getAvailableSeats()});
        }
    }

    private void searchFlights() {
        String origin = originComboBox.getSelectedItem().toString();
        String destination = destinationComboBox.getSelectedItem().toString();

        List<FlightResponse> filteredFlights = flightController.getFlightsByOriginAndDestination(origin, destination);
        displayFlights(filteredFlights);
    }

    private void bookFlight() {
        // simulated booking functionality
        int selectedRow = flightsTable.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Please select a flight.");
            return;
        }

        // fetch the selected flight from the table
        FlightResponse selectedFlight = flightController.getFlightById(selectedRow).getBody();
        if (selectedFlight == null) {
            showMessage("Invalid flight selection.");
            return;
        }

        int seats;
        try {
            seats = Integer.parseInt(seatsTextField.getText());
        } catch (NumberFormatException e) {
            showMessage("Please enter a valid number of seats.");
            return;
        }


        // Update table
        int availableSeats = selectedFlight.getAvailableSeats() - seats;
        selectedFlight.setAvailableSeats(availableSeats);
        tableModel.setValueAt(availableSeats, selectedRow, 8);
        showMessage("Booking successful.");
    }
    private void displayFlights(List<FlightResponse> flights) {
        tableModel.setRowCount(0);
        for (FlightResponse flight : flights) {
            tableModel.addRow(new Object[]{flight.getFlightNumber(), flight.getOriginAirport(), flight.getDestinationAirport(), flight.getCarrier(),
                    flight.getPrice(), flight.getDay(), flight.getTime(), flight.getDuration(), flight.getAvailableSeats()});
        }
    }

    private void showMessage(String message) {
        messageLabel.setText(message);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlightBookingApplication.class, args);

        FlightController flightController = context.getBean(FlightController.class);

        SwingUtilities.invokeLater(() -> new FlightBookingApplication(flightController).setVisible(true));
    }
}
