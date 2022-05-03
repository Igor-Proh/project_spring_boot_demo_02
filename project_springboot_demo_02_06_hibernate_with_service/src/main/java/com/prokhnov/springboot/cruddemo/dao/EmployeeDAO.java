package com.prokhnov.springboot.cruddemo.dao;

import com.prokhnov.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployee(int id);

}

