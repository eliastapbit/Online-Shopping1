public class CartItem {

    // Variables
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    // Default Constructor
    public CartItem() {

    }

    // Parameterized Constructor
    public CartItem(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter for Product ID
    public int getProductId() {
        return productId;
    }

    // Setter for Product ID
    public void setProductId(int productId) {
        this.productId = productId;
    }

    // Getter for Product Name
    public String getProductName() {
        return productName;
    }

    // Setter for Product Name
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter for Price
    public double getPrice() {
        return price;
    }

    // Setter for Price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for Quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for Quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculate Total Price
    public double getTotalPrice() {
        return price * quantity;
    }

    // Display Cart Item
    public void displayCartItem() {
        System.out.println("-------------------------------------");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : ₹" + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Total        : ₹" + getTotalPrice());
        System.out.println("-------------------------------------");
    }
}