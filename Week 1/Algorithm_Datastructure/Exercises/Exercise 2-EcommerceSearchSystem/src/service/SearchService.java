package service;

import model.Product;

public class SearchService {

    public Product linearSearch(Product[] products, String key) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(key)) {
                return p;
            }
        }
        return null;
    }

    public Product binarySearch(Product[] products, String key) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int compare = products[mid].getProductName()
                    .compareToIgnoreCase(key);

            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}