package com.prokhnov.springboot.cruddemo.service;

import com.prokhnov.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
