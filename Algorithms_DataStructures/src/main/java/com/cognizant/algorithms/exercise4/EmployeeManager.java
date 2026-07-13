package com.cognizant.algorithms.exercise4;

import java.util.Arrays;

public class EmployeeManager {
    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 4;

    public EmployeeManager() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Add employee to the array. Resizes array if full.
     * Time Complexity: O(1) amortized, O(N) worst case if array resizing occurs.
     */
    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            resize();
        }
        employees[size++] = employee;
    }

    private void resize() {
        employees = Arrays.copyOf(employees, employees.length * 2);
    }

    /**
     * Search employee by ID.
     * Time Complexity: O(N) worst/average case.
     */
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    /**
     * Traverse and display all employee records.
     * Time Complexity: O(N).
     */
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    /**
     * Delete employee by ID, shifting elements to fill the gap.
     * Time Complexity: O(N) worst/average case.
     */
    public void deleteEmployee(String employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }

        // Shift elements to the left to fill the gap
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[--size] = null; // nullify last reference
    }

    public int getSize() {
        return size;
    }
}
