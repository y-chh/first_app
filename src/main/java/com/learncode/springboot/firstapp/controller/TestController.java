package com.learncode.springboot.firstapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TestController {

    @Value("${employee.name}")
    private String employeeName;

    @Value("${department.name}")
    private String department;

    @GetMapping("/emp_details")
    public String getUserDetails() {
        return "Employee name : " + employeeName + " , Department : " + department;
    }

    @GetMapping("greet")
    public String greet() {
        return "Welcome to my application";
    }
}
