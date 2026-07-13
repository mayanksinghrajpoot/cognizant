package com.cognizant.algorithms.exercise1;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    // HashMap is chosen because it offers O(1) average time complexity for insertion, update, search and deletion.
    private final Map<String, Product> products = new HashMap<>();

    /**
     * Add product to inventory.
     * Time Complexity: O(1) average.
     */
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product already exists with ID: " + product.getProductId());
        }
        products.put(product.getProductId(), product);
    }

    /**
     * Update product details.
     * Time Complexity: O(1) average.
     */
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product p = products.get(productId);
        if (p == null) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
        p.setQuantity(newQuantity);
        p.setPrice(newPrice);
    }

    /**
     * Delete product from inventory.
     * Time Complexity: O(1) average.
     */
    public void deleteProduct(String productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
        products.remove(productId);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public void displayAll() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            products.values().forEach(System.out::println);
        }
    }
}
