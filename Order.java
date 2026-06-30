import java.util.ArrayList;

public class Order {

    // Variables
    private int orderId;
    private int customerId;
    private double totalAmount;

    // List of purchased items
    private ArrayList<CartItem> items;

    // Default Constructor
    public Order() {
        items = new ArrayList<>();
    }

    // Parameterized Constructor
    public Order(int orderId, int customerId, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.items = new ArrayList<>();
    }

    // Getter for Order ID
    public int getOrderId() {
        return orderId;
    }

    // Setter for Order ID
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // Getter for Customer ID
    public int getCustomerId() {
        return customerId;
    }

    // Setter for Customer ID
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getter for Total Amount
    public double getTotalAmount() {
        return totalAmount;
    }

    // Setter for Total Amount
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Get Order Items
    public ArrayList<CartItem> getItems() {
        return items;
    }

    // Add Item to Order
    public void addItem(CartItem item) {
        items.add(item);
    }

    // Display Order Details
    public void displayOrder() {

        System.out.println("\n========== ORDER DETAILS ==========");
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Total Amount  : ₹" + totalAmount);

        System.out.println("\nPurchased Items:");

        for (CartItem item : items) {
            item.displayCartItem();
        }

        System.out.println("===================================");
    }
}