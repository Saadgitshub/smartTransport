package Main.dao;



import Main.Models.Vehicle;
import Main.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private Connection connection;

    public VehicleDAO() {
        connection = DBConnection.getConnection();
    }

    // Create a new vehicle
    public boolean addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (vehicleType, vehicleModel, licensePlate, isAvailable) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getVehicleType());
            stmt.setString(2, vehicle.getVehicleModel());
            stmt.setString(3, vehicle.getLicensePlate());
            stmt.setBoolean(4, vehicle.isAvailable());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all vehicles
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        String sql = "SELECT * FROM vehicles"; // Adjust query as needed

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String vehicleType = rs.getString("vehicleType");
                String vehicleModel = rs.getString("vehicleModel");
                String licensePlate = rs.getString("licensePlate");
                boolean isAvailable = rs.getBoolean("isAvailable");

                // Add the vehicle to the list
                Vehicle vehicle = new Vehicle(id, vehicleType, vehicleModel, licensePlate, isAvailable);
                vehicleList.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleList;
    }

    // Retrieve vehicle by ID
    public Vehicle getVehicleById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Vehicle(
                            rs.getInt("id"),
                            rs.getString("model"),
                            rs.getString("license_plate"),
                            rs.getInt("year")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a vehicle
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET model = ?, license_plate = ?, year = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getLicensePlate());
            stmt.setInt(3, vehicle.getYear());
            stmt.setInt(4, vehicle.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a vehicle
    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

