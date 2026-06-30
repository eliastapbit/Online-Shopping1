import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    // Add Product
    public void addProduct(Product product) {

        String sql = "INSERT INTO PRODUCTS(NAME, PRICE, QUANTITY) VALUES(?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product Added Successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View All Products
    public void viewProducts() {

        String sql = "SELECT * FROM PRODUCTS";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== PRODUCT LIST =====");

            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setPrice(rs.getDouble("PRICE"));
                product.setQuantity(rs.getInt("QUANTITY"));

                product.displayProduct();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Product by ID
    public Product searchProduct(int id) {

        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setPrice(rs.getDouble("PRICE"));
                product.setQuantity(rs.getInt("QUANTITY"));

                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update Product
    public void updateProduct(Product product) {

        String sql = "UPDATE PRODUCTS SET NAME=?, PRICE=?, QUANTITY=? WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setInt(4, product.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product Updated Successfully!");
            } else {
                System.out.println("Product Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Product
    public void deleteProduct(int id) {

        String sql = "DELETE FROM PRODUCTS WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product Deleted Successfully!");
            } else {
                System.out.println("Product Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}