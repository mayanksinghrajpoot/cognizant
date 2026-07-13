package com.cognizant.algorithms.exercise1;

public class Exercise1Demo {
    public static void run() {
        System.out.println("\n=== Exercise 1: Inventory Management System ===");
        Inventory inventory = new Inventory();

        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Headphones", 50, 89.99);

        System.out.println("Adding products...");
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        inventory.displayAll();

        System.out.println("\nUpdating Smartphone quantity to 30 and price to 450.00...");
        inventory.updateProduct("P002", 30, 450.00);
        System.out.println("Updated smartphone: " + inventory.getProduct("P002"));

        System.out.println("\nDeleting Headphones (P003)...");
        inventory.deleteProduct("P003");
        inventory.displayAll();

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Add Product: O(1) average (HashMap put operation)");
        System.out.println("- Update Product: O(1) average (HashMap get and modification)");
        System.out.println("- Delete Product: O(1) average (HashMap remove operation)");
    }
}
