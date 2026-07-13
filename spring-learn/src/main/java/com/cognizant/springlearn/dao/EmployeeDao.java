package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        @SuppressWarnings("unchecked")
        List<Employee> list = context.getBean("employeeList", ArrayList.class);
        EMPLOYEE_LIST.addAll(list);
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            Employee emp = EMPLOYEE_LIST.get(i);
            if (emp.getId() == updatedEmployee.getId()) {
                EMPLOYEE_LIST.set(i, updatedEmployee);
                return;
            }
        }
        throw new RuntimeException("Employee not found with ID: " + updatedEmployee.getId());
    }

    public void deleteEmployee(int id) {
        EMPLOYEE_LIST.removeIf(emp -> emp.getId() == id);
    }
}
