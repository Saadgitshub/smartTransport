package Main.Controllers;


import Main.dao.BookingDAO;
import Main.Models.Booking;

import java.sql.Connection;
import java.util.List;


public class BookingController {
    private BookingDAO bookingDAO;

    public BookingController() {
        Connection connection = null;
        bookingDAO = new BookingDAO();
    }

    public boolean addBooking(Booking booking) {
        bookingDAO.addBooking(booking);
        return false;
    }

    public List<Booking> getBookingsByUserId(int userId) {
        return bookingDAO.getBookingsByUserId(userId);
    }

    public Booking getBookingById(int id) {
        return bookingDAO.getBookingById(id);
    }

    public void updateBooking(Booking booking) {
        bookingDAO.updateBooking(booking);
    }

    public void deleteBooking(int id) {
        bookingDAO.deleteBooking(id);
    }
}
