package com.enterprise.repository;

import com.enterprise.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Override
    Optional<Employee> findById(Integer integer);

    //partial match by name
    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartmentContainingIgnoreCase(String department);

}
