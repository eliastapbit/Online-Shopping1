import java.util.Scanner;

public class Admin {

    private Scanner sc = new Scanner(System.in);

    private ProductDAO productDAO = new ProductDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private OrderDAO orderDAO = new OrderDAO();

    // Admin Menu
    public void adminMenu() {

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("             ADMIN MENU");
            System.out.println("======================================");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. View Customers");
            System.out.println("7. View Orders");
            System.out.println("8. Logout");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    productDAO.viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    customerDAO.viewCustomers();
                    break;

                case 7:
                    orderDAO.viewOrders();
                    break;

                case 8:
                    System.out.println("Admin Logged Out.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);

    }

    // Add Product
    private void addProduct() {

        sc.nextLine();

        Product product = new Product();

        System.out.print("Enter Product Name : ");
        product.setName(sc.nextLine());

        System.out.print("Enter Price : ");
        product.setPrice(sc.nextDouble());

        System.out.print("Enter Quantity : ");
        product.setQuantity(sc.nextInt());

        productDAO.addProduct(product);
    }

    // Search Product
    private void searchProduct() {

        System.out.print("Enter Product ID : ");

        int id = sc.nextInt();

        Product product = productDAO.searchProduct(id);

        if (product != null) {

            product.displayProduct();

        } else {

            System.out.println("Product Not Found.");
        }

    }

    // Update Product
    private void updateProduct() {

        System.out.print("Enter Product ID : ");

        int id = sc.nextInt();

        Product product = productDAO.searchProduct(id);

        if (product == null) {

            System.out.println("Product Not Found.");

            return;
        }

        sc.nextLine();

        System.out.print("Enter New Product Name : ");
        product.setName(sc.nextLine());

        System.out.print("Enter New Price : ");
        product.setPrice(sc.nextDouble());

        System.out.print("Enter New Quantity : ");
        product.setQuantity(sc.nextInt());

        productDAO.updateProduct(product);

    }

    // Delete Product
    private void deleteProduct() {

        System.out.print("Enter Product ID : ");

        int id = sc.nextInt();

        productDAO.deleteProduct(id);

    }

}