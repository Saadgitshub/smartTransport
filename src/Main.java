import Main.utils.DBConnection;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        // Test the connection by calling the DBConnection class
        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("The connection was successful.");
        } else {
            System.out.println("Failed to establish a connection.");
        }
    }
}