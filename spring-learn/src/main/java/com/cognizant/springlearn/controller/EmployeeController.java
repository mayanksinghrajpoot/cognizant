package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("START getAllEmployees");
        List<Employee> list = employeeService.getAllEmployees();
        LOGGER.debug("Employee list size: {}", list.size());
        LOGGER.info("END getAllEmployees");
        return list;
    }

    @PutMapping
    public void updateEmployee(@Valid @RequestBody Employee employee) {
        LOGGER.info("START updateEmployee: {}", employee);
        employeeService.updateEmployee(employee);
        LOGGER.info("END updateEmployee");
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        LOGGER.info("START deleteEmployee ID: {}", id);
        employeeService.deleteEmployee(id);
        LOGGER.info("END deleteEmployee");
    }
}
