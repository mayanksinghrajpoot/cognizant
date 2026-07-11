package com.library.repository;

import com.library.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query Methods with Pagination & Sorting (Exercise 6)
    Page<Employee> findByNameContaining(String name, Pageable pageable);

    // Named Query mapping (Exercise 5)
    Employee findByEmail(@Param("email") String email);

    // Custom query method using @Query
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:pattern%")
    List<Employee> searchByNamePattern(@Param("pattern") String pattern);

    // Interface-based Projection (Exercise 8)
    List<EmployeeProjection> findProjectedByDepartmentId(Long departmentId);

    // Class-based (DTO) Projection (Exercise 8)
    @Query("SELECT new com.library.repository.EmployeeDto(e.id, e.name, e.email) " +
           "FROM Employee e WHERE e.department.id = :deptId")
    List<EmployeeDto> findDtoByDepartmentId(@Param("deptId") Long deptId);
}
