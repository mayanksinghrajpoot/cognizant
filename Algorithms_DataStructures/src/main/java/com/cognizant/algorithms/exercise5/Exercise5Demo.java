package com.cognizant.algorithms.exercise5;

public class Exercise5Demo {
    public static void run() {
        System.out.println("\n=== Exercise 5: Task Management System (Singly Linked List) ===");
        SinglyLinkedList list = new SinglyLinkedList();

        Task t1 = new Task("T001", "Database Setup", "Completed");
        Task t2 = new Task("T002", "API Endpoint Creation", "In Progress");
        Task t3 = new Task("T003", "Frontend Layout Design", "Pending");
        Task t4 = new Task("T004", "Integration Testing", "Pending");

        System.out.println("Adding tasks...");
        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);
        list.addTask(t4);
        list.traverseTasks();

        System.out.println("\nSearching for Task T002...");
        Task found = list.searchTask("T002");
        System.out.println("Search result: " + found);

        System.out.println("\nDeleting Task T003...");
        list.deleteTask("T003");
        list.traverseTasks();

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Add: O(1) (Insert at head node)");
        System.out.println("- Search: O(N) linear scan required");
        System.out.println("- Traverse: O(N) visiting all nodes");
        System.out.println("- Delete: O(N) locating preceding node");
    }
}
