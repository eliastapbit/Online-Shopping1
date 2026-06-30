import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDAO {

    public boolean placeOrder(Order order) {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            // Start Transaction
            con.setAutoCommit(false);

            // Insert into ORDERS table
            String orderSql =
                    "INSERT INTO ORDERS(CUSTOMER_ID, TOTAL_AMOUNT) VALUES(?, ?)";

            PreparedStatement orderPs =
                    con.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);

            orderPs.setInt(1, order.getCustomerId());
            orderPs.setDouble(2, order.getTotalAmount());

            orderPs.executeUpdate();

            // Get Generated Order ID
            ResultSet rs = orderPs.getGeneratedKeys();

            int orderId = 0;

            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // SQL Statements
            String itemSql =
                    "INSERT INTO ORDER_ITEMS(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(?,?,?)";

            String stockSql =
                    "SELECT QUANTITY FROM PRODUCTS WHERE ID=?";

            String updateStockSql =
                    "UPDATE PRODUCTS SET QUANTITY=? WHERE ID=?";

            PreparedStatement itemPs = con.prepareStatement(itemSql);
            PreparedStatement stockPs = con.prepareStatement(stockSql);
            PreparedStatement updatePs = con.prepareStatement(updateStockSql);

            // Save all purchased items
            for (CartItem item : order.getItems()) {

                // Check Stock
                stockPs.setInt(1, item.getProductId());

                ResultSet stockRs = stockPs.executeQuery();

                if (stockRs.next()) {

                    int availableQty = stockRs.getInt("QUANTITY");

                    if (availableQty < item.getQuantity()) {

                        System.out.println("Not enough stock for "
                                + item.getProductName());

                        con.rollback();

                        return false;
                    }

                    // Save Order Item
                    itemPs.setInt(1, orderId);
                    itemPs.setInt(2, item.getProductId());
                    itemPs.setInt(3, item.getQuantity());

                    itemPs.executeUpdate();

                    // Update Stock
                    int newQty = availableQty - item.getQuantity();

                    updatePs.setInt(1, newQty);
                    updatePs.setInt(2, item.getProductId());

                    updatePs.executeUpdate();

                } else {

                    System.out.println("Product Not Found.");

                    con.rollback();

                    return false;
                }

                stockRs.close();
            }

            // Commit Transaction
            con.commit();

            System.out.println("Order Placed Successfully!");

            itemPs.close();
            stockPs.close();
            updatePs.close();
            orderPs.close();
            con.close();

            return true;

        } catch (Exception e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

            return false;

        }
    }

    // View All Orders
    public void viewOrders() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM ORDERS";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== ORDER HISTORY ==========");

            while (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("Order ID      : " + rs.getInt("ORDER_ID"));
                System.out.println("Customer ID   : " + rs.getInt("CUSTOMER_ID"));
                System.out.println("Total Amount  : ₹" + rs.getDouble("TOTAL_AMOUNT"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}