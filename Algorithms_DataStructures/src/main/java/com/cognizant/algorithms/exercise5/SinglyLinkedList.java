package com.cognizant.algorithms.exercise5;

public class SinglyLinkedList {

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    /**
     * Add task at the beginning of the linked list.
     * Time Complexity: O(1).
     */
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Search for a task by ID.
     * Time Complexity: O(N) worst/average case.
     */
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equalsIgnoreCase(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Traverse and display all tasks in the list.
     * Time Complexity: O(N).
     */
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found in list.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    /**
     * Delete a task by ID.
     * Time Complexity: O(N) worst/average case.
     */
    public void deleteTask(String taskId) {
        if (head == null) {
            throw new IllegalArgumentException("Task list is empty");
        }

        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equalsIgnoreCase(taskId)) {
            current = current.next;
        }

        if (current.next == null) {
            throw new IllegalArgumentException("Task not found with ID: " + taskId);
        }

        current.next = current.next.next;
    }
}
