package com.cognizant.algorithms.exercise4;

public class Exercise4Demo {
    public static void run() {
        System.out.println("\n=== Exercise 4: Employee Management System (Array) ===");
        EmployeeManager manager = new EmployeeManager();

        Employee emp1 = new Employee("E001", "Alice", "Software Engineer", 75000);
        Employee emp2 = new Employee("E002", "Bob", "HR Manager", 65000);
        Employee emp3 = new Employee("E003", "Charlie", "Product Manager", 90000);
        Employee emp4 = new Employee("E004", "David", "QA Engineer", 55000);

        System.out.println("Adding employees...");
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);
        manager.addEmployee(emp4);
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee E003...");
        Employee found = manager.searchEmployee("E003");
        System.out.println("Search result: " + found);

        System.out.println("\nDeleting Employee E002...");
        manager.deleteEmployee("E002");
        manager.traverseEmployees();

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Add: O(1) average, O(N) when resizing occurs.");
        System.out.println("- Search: O(N) linear scan required.");
        System.out.println("- Traverse: O(N) visiting all elements.");
        System.out.println("- Delete: O(N) shifting elements to fill the gap.");
    }
}
