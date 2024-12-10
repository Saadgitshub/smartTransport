package ui;

import Main.Models.Booking;
import Main.Models.User;
import Main.dao.BookingDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.List;

public class BookingHistoryForm {
    private JFrame frame;
    private User loggedInUser;
    private BookingDAO bookingDAO;

    public BookingHistoryForm(User user, Connection connection) {
        this.loggedInUser = user;
        this.bookingDAO = new BookingDAO();

        frame = new JFrame("Booking History");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        initialize();
    }

    private void initialize() {
        List<Booking> bookings = bookingDAO.getBookingsByUserId(loggedInUser.getId());
        String[] columnNames = {"Booking ID", "Vehicle ID", "Booking Date", "Start Date", "End Date"};
        String[][] data = new String[bookings.size()][5];

        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            data[i][0] = String.valueOf(booking.getId());
            data[i][1] = String.valueOf(booking.getVehicleId());
            data[i][2] = booking.getBookingDate().toString();
            data[i][3] = booking.getStartDate().toString();
            data[i][4] = booking.getEndDate().toString();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    public void showWindow() {
        frame.setVisible(true);
    }
}
