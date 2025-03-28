import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://localhost:5432/project name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void getConnection() {
        Connection connection ;
        try {
            Class.forName("org.postgresql.Driver"); // Load PostgreSQL driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getConnection();
    }
}
