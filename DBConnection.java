import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Database URL
    private static final String URL = "jdbc:h2:./database/OnlineShoppingDB";

    // Default H2 username
    private static final String USER = "sa";

    // Default H2 password
    private static final String PASSWORD = "";

    // Method to create and return a database connection
    public static Connection getConnection() {

        try {

            // Connect to H2 Database
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

            return con;

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");

            e.printStackTrace();

            return null;
        }
    }
}