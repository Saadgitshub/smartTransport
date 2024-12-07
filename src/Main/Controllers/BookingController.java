package Main.Controllers;


import Main.dao.BookingDAO;
import Main.Models.Booking;

import java.util.List;

public class BookingController {
    private BookingDAO bookingDAO;

    public BookingController() {
        bookingDAO = new BookingDAO();
    }

    public void createBooking(Booking booking) {
        bookingDAO.createBooking(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
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
