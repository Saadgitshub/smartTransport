package Main.Models;


import java.util.Date;

public class Booking {
    private int id;
    private int userId;
    private int vehicleId;
    private Date bookingDate;
    private Date startDate;
    private Date endDate;

    // Constructors
    public Booking() {}

    public Booking(int id, int userId, int vehicleId, Date bookingDate, Date startDate, Date endDate) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Booking(int id, int userId, int vehicleId, Date bookingDate) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.bookingDate = bookingDate;
        // You can set default values for startDate and endDate if required
        this.startDate = new Date(); // or null if preferred
        this.endDate = new Date();   // or null if preferred
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
