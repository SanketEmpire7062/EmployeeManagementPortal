package com.enterprise.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    private  String name;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid Email format")
    @Column(unique = true, nullable = false)
    private String email;


    @NotNull(message = "Department is required")
    private String department;

    @NotNull(message = "Joining date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date joiningDate;

    @NotNull(message = "Salary is required")
    private Double salary;


    @NotNull(message = "Mobile No is required")
    private Double mobileNo;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active = true;

    public Boolean getActive() {
        return active;
    }


    public Double getSalary() {
        return salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Double getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Double mobileNo) {
        this.mobileNo = mobileNo;
    }
}
