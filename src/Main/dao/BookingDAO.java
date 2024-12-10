package Main.dao;

import Main.Models.Booking;
import Main.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    private Connection connection;

    // Constructor with connection initialization
    public BookingDAO() {
        this.connection = DBConnection.getConnection();
        if (this.connection == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }
    }



    // Create a new booking
    public void addBooking(Booking booking) {
        if (connection == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }

        String query = "INSERT INTO bookings (userId, vehicleId, bookingDate, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getVehicleId());
            stmt.setTimestamp(3, new Timestamp(booking.getBookingDate().getTime()));
            stmt.setTimestamp(4, new Timestamp(booking.getStartDate().getTime()));
            stmt.setTimestamp(5, new Timestamp(booking.getEndDate().getTime()));

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Booking added successfully, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all bookings by userId
    public List<Booking> getBookingsByUserId(int userId) {
        if (connection == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }

        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getInt("vehicleId"),
                        rs.getTimestamp("bookingDate"),
                        rs.getTimestamp("startDate"),
                        rs.getTimestamp("endDate")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // Retrieve a booking by ID
    public Booking getBookingById(int id) {
        if (connection == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }

        String sql = "SELECT * FROM bookings WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Booking(
                            rs.getInt("id"),
                            rs.getInt("userId"),
                            rs.getInt("vehicleId"),
                            rs.getTimestamp("bookingDate"),
                            rs.getTimestamp("startDate"),
                            rs.getTimestamp("endDate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a booking
    public void updateBooking(Booking booking) {
        if (connection == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }

        String sql = "UPDATE bookings SET userId = ?, vehicleId = ?, bookingDate = ?, startDate = ?, endDate = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getVehicleId());
            stmt.setTimestamp(3, new Timestamp(booking.getBookingDate().getTime()));
            stmt.setTimestamp(4, new Timestamp(booking.getStartDate().getTime()));
            stmt.setTimestamp(5, new Timestamp(booking.getEndDate().getTime()));
            stmt.setInt(6, booking.getId());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Booking updated successfully, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a booking
    public void deleteBooking(int id) {
        if (connection == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }

        String sql = "DELETE FROM bookings WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Booking deleted successfully, rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
