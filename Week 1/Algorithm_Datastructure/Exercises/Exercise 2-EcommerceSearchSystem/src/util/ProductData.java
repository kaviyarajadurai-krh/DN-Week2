package util;

import model.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductData {

    public static Product[] getProducts() {
        return new Product[]{
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Mobile", "Electronics"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Tablet", "Electronics")
        };
    }

    public static Product[] getSortedProducts() {
        Product[] products = getProducts();

        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        return products;
    }
}