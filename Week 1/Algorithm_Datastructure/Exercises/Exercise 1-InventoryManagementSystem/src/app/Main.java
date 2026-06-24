package app;

import model.Product;
import service.Inventory;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(101, "Laptop", 10, 55000));
        inventory.addProduct(new Product(102, "Mouse", 50, 500));
        inventory.addProduct(new Product(103, "Keyboard", 30, 1200));

        System.out.println("Initial Inventory:");
        inventory.displayProducts();

        inventory.updateProduct(101, 8, 54000);
        inventory.deleteProduct(102);

        System.out.println("\nAfter Update:");
        inventory.displayProducts();
    }
}