package com.cognizant.algorithms.exercise2;

import java.util.Arrays;

public class Exercise2Demo {
    public static void run() {
        System.out.println("\n=== Exercise 2: E-commerce Platform Search Function ===");

        Product[] products = {
                new Product("P103", "Mechanical Keyboard", "Electronics"),
                new Product("P101", "Wireless Mouse", "Electronics"),
                new Product("P105", "Desk Lamp", "Furniture"),
                new Product("P102", "USB-C Cable", "Accessories"),
                new Product("P104", "Gaming Monitor", "Electronics")
        };

        System.out.println("Running Linear Search for P104...");
        Product resLinear = SearchUtils.linearSearch(products, "P104");
        System.out.println("Linear Search result: " + resLinear);

        System.out.println("\nSorting array by Product ID for Binary Search...");
        Arrays.sort(products);
        System.out.println("Sorted products array:");
        for (Product p : products) {
            System.out.println("  " + p);
        }

        System.out.println("\nRunning Binary Search for P104...");
        Product resBinary = SearchUtils.binarySearch(products, "P104");
        System.out.println("Binary Search result: " + resBinary);

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Linear Search: O(N) worst/average, O(1) best. No sorting requirement.");
        System.out.println("- Binary Search: O(log N) worst/average, O(1) best. Requires pre-sorted dataset.");
    }
}
