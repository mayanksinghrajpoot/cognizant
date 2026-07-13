package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static final List<Department> DEPARTMENT_LIST = new ArrayList<>();

    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        @SuppressWarnings("unchecked")
        List<Department> list = context.getBean("departmentList", ArrayList.class);
        DEPARTMENT_LIST.addAll(list);
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
