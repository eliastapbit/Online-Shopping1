import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables() {

        try {

            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            // ADMIN Table
            stmt.execute("CREATE TABLE IF NOT EXISTS ADMIN ("
                    + "USERNAME VARCHAR(50) PRIMARY KEY,"
                    + "PASSWORD VARCHAR(50))");

            // Insert default admin
            stmt.execute("MERGE INTO ADMIN KEY(USERNAME) VALUES('admin','admin123')");

            // CUSTOMERS Table
            stmt.execute("CREATE TABLE IF NOT EXISTS CUSTOMERS ("
                    + "ID INT AUTO_INCREMENT PRIMARY KEY,"
                    + "NAME VARCHAR(100),"
                    + "EMAIL VARCHAR(100),"
                    + "PASSWORD VARCHAR(50))");

            // PRODUCTS Table
            stmt.execute("CREATE TABLE IF NOT EXISTS PRODUCTS ("
                    + "ID INT AUTO_INCREMENT PRIMARY KEY,"
                    + "NAME VARCHAR(100),"
                    + "PRICE DOUBLE,"
                    + "QUANTITY INT)");

            // ORDERS Table
            stmt.execute("CREATE TABLE IF NOT EXISTS ORDERS ("
                    + "ORDER_ID INT AUTO_INCREMENT PRIMARY KEY,"
                    + "CUSTOMER_ID INT,"
                    + "TOTAL_AMOUNT DOUBLE)");

            // ORDER_ITEMS Table
            
stmt.execute("CREATE TABLE IF NOT EXISTS ORDER_ITEMS ("
        + "ITEM_ID INT AUTO_INCREMENT PRIMARY KEY,"
        + "ORDER_ID INT,"
        + "PRODUCT_ID INT,"
        + "QUANTITY INT,"
        + "PRICE DOUBLE)");

            System.out.println("All tables created successfully.");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}