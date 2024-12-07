package Main.dao;



import Main.Models.Booking;
import Main.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private Connection connection;

    public BookingDAO() {
        connection = DBConnection.getConnection();
    }

    // Create a new booking
    public void createBooking(Booking booking) {
        String sql = "INSERT INTO bookings (user_id, vehicle_id, booking_date, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getVehicleId());
            stmt.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
            stmt.setDate(4, new java.sql.Date(booking.getStartDate().getTime()));
            stmt.setDate(5, new java.sql.Date(booking.getEndDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("vehicle_id"),
                        rs.getDate("booking_date"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date")
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
        String sql = "SELECT * FROM bookings WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Booking(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("vehicle_id"),
                            rs.getDate("booking_date"),
                            rs.getDate("start_date"),
                            rs.getDate("end_date")
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
        String sql = "UPDATE bookings SET user_id = ?, vehicle_id = ?, booking_date = ?, start_date = ?, end_date = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getVehicleId());
            stmt.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
            stmt.setDate(4, new java.sql.Date(booking.getStartDate().getTime()));
            stmt.setDate(5, new java.sql.Date(booking.getEndDate().getTime()));
            stmt.setInt(6, booking.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a booking
    public void deleteBooking(int id) {
        String sql = "DELETE FROM bookings WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
