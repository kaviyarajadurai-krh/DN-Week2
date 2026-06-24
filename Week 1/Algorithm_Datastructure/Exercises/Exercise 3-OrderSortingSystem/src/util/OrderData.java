package util;

import model.Order;

public class OrderData {

    public static Order[] getOrders() {
        return new Order[]{
                new Order(1, "Kaviya", 4500),
                new Order(2, "Arun", 1200),
                new Order(3, "Meena", 9999),
                new Order(4, "John", 3000),
                new Order(5, "Sara", 7500)
        };
    }
}