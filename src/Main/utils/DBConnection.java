package Main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        // Define the connection string
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TransportDB;user=Throw;password=123456;trustServerCertificate=true;";


        // Initialize the connection
        Connection connection = null;

        try {
            // Load the SQL Server JDBC Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the connection
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection successful!");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return connection;
    }
}
