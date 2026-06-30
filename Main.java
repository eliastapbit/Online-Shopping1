import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static Login login = new Login();
    static Admin admin = new Admin();
    static CustomerDAO customerDAO = new CustomerDAO();

    public static void main(String[] args) {

        // Create database tables
        DatabaseSetup.createTables();

        int choice;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("     ONLINE SHOPPING SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Registration");
            System.out.println("3. Customer Login");
            System.out.println("4. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    adminLogin();
                    break;

                case 2:
                    registerCustomer();
                    break;

                case 3:
                    customerLogin();
                    break;

                case 4:
                    System.out.println("Thank you for using Online Shopping System.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

    }

    // ---------------- ADMIN LOGIN ----------------

    public static void adminLogin() {

        sc.nextLine();

        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        if (login.adminLogin(username, password)) {

            System.out.println("Admin Login Successful.");

            admin.adminMenu();

        } else {

            System.out.println("Invalid Username or Password.");
        }

    }

    // ---------------- CUSTOMER REGISTER ----------------

    public static void registerCustomer() {

        sc.nextLine();

        Customer customer = new Customer();

        System.out.print("Enter Name : ");
        customer.setName(sc.nextLine());

        System.out.print("Enter Email : ");
        customer.setEmail(sc.nextLine());

        System.out.print("Enter Password : ");
        customer.setPassword(sc.nextLine());

        customerDAO.registerCustomer(customer);

    }

    // ---------------- CUSTOMER LOGIN ----------------

    public static void customerLogin() {

        sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        Customer customer = login.customerLogin(email, password);

        if (customer != null) {

            System.out.println("Customer Login Successful.");

            // Customer menu will be added next

        } else {

            System.out.println("Invalid Email or Password.");

        }

    }

}