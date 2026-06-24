package app;

import model.Product;
import service.SearchService;
import util.ProductData;

public class Main {
    public static void main(String[] args) {

        SearchService service = new SearchService();

        // Linear Search
        Product[] unsorted = ProductData.getProducts();

        System.out.println("🔍 Linear Search Result:");
        Product result1 = service.linearSearch(unsorted, "Mobile");
        System.out.println(result1 != null ? result1 : "Not Found");

        // Binary Search
        Product[] sorted = ProductData.getSortedProducts();

        System.out.println("\n🔍 Binary Search Result:");
        Product result2 = service.binarySearch(sorted, "Mobile");
        System.out.println(result2 != null ? result2 : "Not Found");
    }
}