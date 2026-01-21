package com.enterprise.controller;

import com.enterprise.entity.Employee;
import com.enterprise.repository.EmployeeRepository;
import com.enterprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public ResponseEntity<?> getEmployeeByName(
            @RequestParam(required = false) String name
    ){

        List<Employee> employees = employeeService.getEmployeeByName(name);

        if(employees.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        return ResponseEntity.ok(employees);
    }



    @GetMapping("/department")
    public ResponseEntity<?> getEmployeeByDepartment(
            @RequestParam(required = false) String department
    ){
        List<Employee> employees = employeeService.getEmployeeByDepartment(department);

        if(employees.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }

        return ResponseEntity.ok(employees);

    }

    @GetMapping("/joiningdate")
    public ResponseEntity<?>getEmployeeByJoiningDate(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate

    ){
        List<Employee> employees = employeeService.getEmployeeByJoiningData(startDate, endDate);

        if(employees.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");

        }
        return ResponseEntity.ok(employees);
    }






}
