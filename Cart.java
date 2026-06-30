import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> cartItems;

    // Constructor
    public Cart() {
        cartItems = new ArrayList<>();
    }

    // Add Product to Cart
    public void addItem(CartItem newItem) {

        // If product already exists, increase quantity
        for (CartItem item : cartItems) {

            if (item.getProductId() == newItem.getProductId()) {

                item.setQuantity(item.getQuantity() + newItem.getQuantity());

                System.out.println("Product quantity updated in cart.");

                return;
            }
        }

        cartItems.add(newItem);

        System.out.println("Product added to cart successfully.");
    }

    // Remove Product
    public void removeItem(int productId) {

        for (int i = 0; i < cartItems.size(); i++) {

            if (cartItems.get(i).getProductId() == productId) {

                cartItems.remove(i);

                System.out.println("Product removed from cart.");

                return;
            }
        }

        System.out.println("Product not found in cart.");
    }

    // Display Cart
    public void viewCart() {

        if (cartItems.isEmpty()) {

            System.out.println("\nCart is Empty.");

            return;
        }

        System.out.println("\n========== YOUR CART ==========");

        for (CartItem item : cartItems) {

            item.displayCartItem();
        }

        System.out.println("--------------------------------");
        System.out.println("Grand Total : ₹" + getTotalAmount());
        System.out.println("--------------------------------");
    }

    // Calculate Total
    public double getTotalAmount() {

        double total = 0;

        for (CartItem item : cartItems) {

            total += item.getTotalPrice();
        }

        return total;
    }

    // Check Empty Cart
    public boolean isEmpty() {

        return cartItems.isEmpty();
    }

    // Clear Cart
    public void clearCart() {

        cartItems.clear();
    }

    // Return Cart Items
    public ArrayList<CartItem> getCartItems() {

        return cartItems;
    }

    // Display Total Items
    public void displayTotalItems() {

        System.out.println("Total Items : " + cartItems.size());
    }

}