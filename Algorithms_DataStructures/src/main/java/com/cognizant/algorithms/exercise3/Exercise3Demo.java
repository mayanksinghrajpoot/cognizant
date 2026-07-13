package com.cognizant.algorithms.exercise3;

import java.util.Arrays;

public class Exercise3Demo {
    public static void run() {
        System.out.println("\n=== Exercise 3: Sorting Customer Orders ===");

        Order[] bubbleOrders = {
                new Order("O001", "Alice", 250.50),
                new Order("O002", "Bob", 89.99),
                new Order("O003", "Charlie", 1200.00),
                new Order("O004", "David", 45.00),
                new Order("O005", "Emma", 350.00)
        };

        Order[] quickOrders = Arrays.copyOf(bubbleOrders, bubbleOrders.length);

        System.out.println("Original orders list:");
        for (Order o : bubbleOrders) {
            System.out.println("  " + o);
        }

        System.out.println("\nSorting using Bubble Sort...");
        SortUtils.bubbleSort(bubbleOrders);
        for (Order o : bubbleOrders) {
            System.out.println("  " + o);
        }

        System.out.println("\nSorting using Quick Sort...");
        SortUtils.quickSort(quickOrders, 0, quickOrders.length - 1);
        for (Order o : quickOrders) {
            System.out.println("  " + o);
        }

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Bubble Sort: O(N^2) worst and average case. High comparisons and swaps.");
        System.out.println("- Quick Sort: O(N log N) average case, O(N^2) worst case. Divides and conquers using pivot.");
    }
}
