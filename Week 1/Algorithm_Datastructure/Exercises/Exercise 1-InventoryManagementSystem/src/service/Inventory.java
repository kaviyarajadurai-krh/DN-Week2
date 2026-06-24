package service;

import model.Product;
import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.getProductId(), p);
    }

    public void updateProduct(int id, int quantity, double price) {
        if (products.containsKey(id)) {
            Product p = products.get(id);
            p.setQuantity(quantity);
            p.setPrice(price);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int id) {
        if (products.remove(id) == null) {
            System.out.println("Product not found!");
        }
    }

    public void displayProducts() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}