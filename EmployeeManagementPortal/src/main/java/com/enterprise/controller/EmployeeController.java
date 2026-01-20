package com.enterprise.controller;

import com.enterprise.entity.Employee;
import com.enterprise.repository.EmployeeRepository;
import com.enterprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping
    public Page<Employee> getEmployeeByPagination(
            @RequestParam(defaultValue = "0") int page
    ){
        return employeeService.getEmployee(page);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
                

    }

    @GetMapping("/name")
    public List<Employee> getEmployeeByName(
            @RequestParam(required = false) String name
    ){
        return employeeService.getEmployeeByName(name);
    }




}
