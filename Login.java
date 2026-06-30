import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    // ---------------- ADMIN LOGIN ----------------

    public boolean adminLogin(String username, String password) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM ADMIN WHERE USERNAME=? AND PASSWORD=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            boolean success = rs.next();

            rs.close();
            ps.close();
            con.close();

            return success;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // ---------------- CUSTOMER LOGIN ----------------

    public Customer customerLogin(String email, String password) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM CUSTOMERS WHERE EMAIL=? AND PASSWORD=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            Customer customer = null;

            if (rs.next()) {

                customer = new Customer();

                customer.setId(rs.getInt("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setPassword(rs.getString("PASSWORD"));
            }

            rs.close();
            ps.close();
            con.close();

            return customer;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

}