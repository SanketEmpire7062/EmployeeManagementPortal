package com.enterprise.service;

import com.enterprise.entity.Employee;
import com.enterprise.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }
}
