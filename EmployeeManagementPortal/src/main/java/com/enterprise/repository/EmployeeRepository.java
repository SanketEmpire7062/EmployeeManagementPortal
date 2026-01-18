package com.enterprise.repository;

import com.enterprise.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Override
    Optional<Employee> findById(Integer integer);
}
