package Main.Controllers;

import Main.dao.VehicleDAO;
import Main.Models.Vehicle;

import java.util.List;

public class VehicleController {
    private VehicleDAO vehicleDAO;

    public VehicleController() {
        vehicleDAO = new VehicleDAO();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleDAO.addVehicle(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }

    public Vehicle getVehicleById(int id) {
        return vehicleDAO.getVehicleById(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleDAO.updateVehicle(vehicle);
    }

    public void deleteVehicle(int id) {
        vehicleDAO.deleteVehicle(id);
    }
}
