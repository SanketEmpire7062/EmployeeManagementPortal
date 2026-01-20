package com.enterprise.service;

import com.enterprise.entity.Employee;
import com.enterprise.exception.ResourceNotFoundException;
import com.enterprise.repository.EmployeeRepository;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployee() {

        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id) {

        return employeeRepository.findById(id);

    }

    public Page<Employee> getEmployee(int page) {
        int pageSize = 4;
        PageRequest pageRequest = PageRequest.of(page, pageSize);

        return employeeRepository.findAll(pageRequest);
    }

    // getting employee by name
    public List<Employee> getEmployeeByName(String name) {


        return employeeRepository.findByNameContainingIgnoreCase(name);

    }

    //getting employee by department
    public List<Employee> getEmployeeByDepartment(String department){

        return employeeRepository.findByDepartmentContainingIgnoreCase(department);
    }





}
