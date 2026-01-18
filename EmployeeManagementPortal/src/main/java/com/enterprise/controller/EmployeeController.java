package com.enterprise.controller;

import com.enterprise.entity.Employee;
import com.enterprise.repository.EmployeeRepository;
import com.enterprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
                

    }




}
