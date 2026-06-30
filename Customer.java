public class Customer {

    // Variables
    private int id;
    private String name;
    private String email;
    private String password;

    // Default Constructor
    public Customer() {

    }

    // Parameterized Constructor
    public Customer(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    // Getter for Email
    public String getEmail() {
        return email;
    }

    // Setter for Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for Password
    public String getPassword() {
        return password;
    }

    // Setter for Password
    public void setPassword(String password) {
        this.password = password;
    }

    // Display Customer Details
    public void displayCustomer() {
        System.out.println("-----------------------------------");
        System.out.println("Customer ID   : " + id);
        System.out.println("Customer Name : " + name);
        System.out.println("Email         : " + email);
        System.out.println("-----------------------------------");
    }
}