import java.util.ArrayList;
import java.util.List;

// Product class representing any item of any ECommerce.
class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCartInvoice{
    private ShoppingCart cart;
    public ShoppingCartInvoice(ShoppingCart cart){
        this.cart = cart;
    }

      public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }

}

class ShoppingCartStorage{

    private ShoppingCart cart;
    public ShoppingCartStorage(ShoppingCart cart){
        this.cart = cart;
    }

     // 3. Violating SRP - Saves to DB (Should be in a separate class)
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }

}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    // 1. Calculates total price in cart.
    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }


  
}

public class SRPCorrect {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartInvoice invoice = new ShoppingCartInvoice(cart);
        invoice.printInvoice();

        ShoppingCartStorage storage = new ShoppingCartStorage(cart);
        storage.saveToDatabase();

       
    }
}