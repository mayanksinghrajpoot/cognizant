package com.library;

import com.library.entity.Employee;
import com.library.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        assertNotNull(employeeService);
    }

    @Test
    void testCrudOperations() {
        List<Employee> all = employeeService.getAllEmployees();
        assertFalse(all.isEmpty());
        // Seed should have created Alice, Bob, Charlie + 50 batch users = 53 total
        assertTrue(all.size() >= 53);
    }
}
