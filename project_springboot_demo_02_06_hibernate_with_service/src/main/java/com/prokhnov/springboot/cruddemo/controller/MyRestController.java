package com.prokhnov.springboot.cruddemo.controller;

import com.prokhnov.springboot.cruddemo.entity.Employee;
import com.prokhnov.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private EmployeeService employeeService;

    @Autowired
    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        Employee employee = employeeService.findById(id);

        if (employee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {

        employee.setId(0);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employee = employeeService.findById(id);

        if (employee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteEmployee(id);
        return "Employee with id - " + id + " was deleted !";
    }
}
