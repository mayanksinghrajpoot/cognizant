package com.cognizant.algorithms.exercise6;

import java.util.Arrays;

public class Exercise6Demo {
    public static void run() {
        System.out.println("\n=== Exercise 6: Library Management System ===");

        Book[] books = {
                new Book("B003", "Effective Java", "Joshua Bloch"),
                new Book("B001", "Clean Code", "Robert C. Martin"),
                new Book("B005", "Design Patterns", "Erich Gamma"),
                new Book("B002", "Introduction to Algorithms", "Thomas H. Cormen"),
                new Book("B004", "The Pragmatic Programmer", "Andy Hunt")
        };

        System.out.println("Running Linear Search for 'Design Patterns'...");
        Book resLinear = LibrarySearch.linearSearch(books, "Design Patterns");
        System.out.println("Linear Search result: " + resLinear);

        System.out.println("\nSorting library books by title for Binary Search...");
        Arrays.sort(books);
        System.out.println("Sorted books array:");
        for (Book b : books) {
            System.out.println("  " + b);
        }

        System.out.println("\nRunning Binary Search for 'Design Patterns'...");
        Book resBinary = LibrarySearch.binarySearch(books, "Design Patterns");
        System.out.println("Binary Search result: " + resBinary);

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Linear Search: O(N) worst/average case. Applicable to unsorted books lists.");
        System.out.println("- Binary Search: O(log N) worst/average case. Must be pre-sorted by search key.");
    }
}
