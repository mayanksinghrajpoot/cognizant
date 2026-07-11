package com.library;

import com.library.entity.Department;
import com.library.entity.Employee;
import com.library.repository.EmployeeDto;
import com.library.repository.EmployeeProjection;
import com.library.repository.EmployeeRepository;
import com.library.service.DepartmentService;
import com.library.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            DepartmentService departmentService,
            EmployeeService employeeService,
            EmployeeRepository employeeRepository
    ) {
        return args -> {
            System.out.println("--- Seeding Employee Management System database ---");

            Department sales = departmentService.saveDepartment(new Department("Sales"));
            Department eng = departmentService.saveDepartment(new Department("Engineering"));

            Employee e1 = employeeService.saveEmployee(new Employee("Alice Smith", "alice@example.com", sales));
            Employee e2 = employeeService.saveEmployee(new Employee("Bob Johnson", "bob@example.com", eng));
            Employee e3 = employeeService.saveEmployee(new Employee("Charlie Brown", "charlie@example.com", eng));

            System.out.println("--- Seed Completed ---");

            // Verify Auditing (Exercise 7)
            Employee fetched = employeeService.getEmployeeById(e1.getId()).orElse(null);
            if (fetched != null) {
                System.out.println("Audited Employee Created By: " + fetched.getCreatedBy());
                System.out.println("Audited Employee Created Date: " + fetched.getCreatedDate());
            }

            // Verify Projections (Exercise 8)
            System.out.println("--- Interface-based Projections: ---");
            List<EmployeeProjection> projectedList = employeeRepository.findProjectedByDepartmentId(eng.getId());
            for (EmployeeProjection proj : projectedList) {
                System.out.println("Projected Employee: ID=" + proj.getId() + ", Name=" + proj.getName() + ", Email=" + proj.getEmail());
            }

            System.out.println("--- Class-based Projections (DTO): ---");
            List<EmployeeDto> dtoList = employeeRepository.findDtoByDepartmentId(eng.getId());
            for (EmployeeDto dto : dtoList) {
                System.out.println("DTO Employee: " + dto);
            }

            // Verify Pagination and Sorting (Exercise 6)
            System.out.println("--- Pagination & Sorting Search (Page 0, Size 2, Sorted by name): ---");
            employeeService.searchEmployees("o", PageRequest.of(0, 2, Sort.by("name").ascending()))
                    .forEach(emp -> System.out.println("Page Result Employee: " + emp.getName()));

            // Verify Batch Processing (Exercise 10)
            System.out.println("--- Executing Batch Insert of 50 Employees ---");
            List<Employee> batchList = new ArrayList<>();
            for (int i = 1; i <= 50; i++) {
                batchList.add(new Employee("BatchUser " + i, "batch" + i + "@example.com", sales));
            }
            employeeService.saveEmployeesInBatch(batchList);
            System.out.println("Batch Insert Completed. Total employee count: " + employeeRepository.count());
        };
    }
}
