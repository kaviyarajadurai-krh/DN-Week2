package app;

import model.Order;
import service.SortingService;
import util.OrderData;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SortingService service = new SortingService();

        // Bubble Sort
        Order[] bubbleOrders = OrderData.getOrders();
        service.bubbleSort(bubbleOrders);

        System.out.println("🫧 Bubble Sorted Orders:");
        System.out.println(Arrays.toString(bubbleOrders));

        // Quick Sort
        Order[] quickOrders = OrderData.getOrders();
        service.quickSort(quickOrders, 0, quickOrders.length - 1);

        System.out.println("\n⚡ Quick Sorted Orders:");
        System.out.println(Arrays.toString(quickOrders));
    }
}