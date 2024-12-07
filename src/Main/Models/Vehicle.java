package Main.Models;

public class Vehicle {
    private int id;
    private String vehicleType;
    private String vehicleModel;
    private String licensePlate;
    private boolean isAvailable;

    // Constructors
    public Vehicle(int id, String model, String licensePlate, int year) {}

    public Vehicle(int id, String vehicleType, String vehicleModel, String licensePlate, boolean isAvailable) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.licensePlate = licensePlate;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getModel() {
        return null;
    }

    public int getYear() {
        return 0;
    }
}
