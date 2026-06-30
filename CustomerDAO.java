import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    // Register Customer
    public void registerCustomer(Customer customer) {

        String sql = "INSERT INTO CUSTOMERS(NAME, EMAIL, PASSWORD) VALUES(?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Registered Successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Customer Login
    public Customer loginCustomer(String email, String password) {

        String sql = "SELECT * FROM CUSTOMERS WHERE EMAIL=? AND PASSWORD=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Customer customer = new Customer();

                customer.setId(rs.getInt("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setPassword(rs.getString("PASSWORD"));

                return customer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // View All Customers
    public void viewCustomers() {

        String sql = "SELECT * FROM CUSTOMERS";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== CUSTOMER LIST =====");

            while (rs.next()) {

                Customer customer = new Customer();

                customer.setId(rs.getInt("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));

                customer.displayCustomer();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Customer by ID
    public Customer searchCustomer(int id) {

        String sql = "SELECT * FROM CUSTOMERS WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Customer customer = new Customer();

                customer.setId(rs.getInt("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setPassword(rs.getString("PASSWORD"));

                return customer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}