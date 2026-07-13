package com.cognizant.algorithms.exercise2;

public class SearchUtils {

    /**
     * Linear Search implementation.
     * Time Complexity: O(N) worst and average case, O(1) best case.
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(targetId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary Search implementation (assumes sorted array).
     * Time Complexity: O(log N) worst and average case, O(1) best case.
     */
    public static Product binarySearch(Product[] sortedProducts, String targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedProducts[mid].getProductId().compareToIgnoreCase(targetId);

            if (comparison == 0) {
                return sortedProducts[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
