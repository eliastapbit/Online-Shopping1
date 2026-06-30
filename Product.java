public class Product {

    // Variables
    private int id;
    private String name;
    private double price;
    private int quantity;

    // Default Constructor
    public Product() {

    }

    // Parameterized Constructor
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        this.name = name;
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

    // Display Product
    public void displayProduct() {
        System.out.println("-----------------------------------");
        System.out.println("Product ID      : " + id);
        System.out.println("Product Name    : " + name);
        System.out.println("Price           : ₹" + price);
        System.out.println("Quantity        : " + quantity);
        System.out.println("-----------------------------------");
    }
}