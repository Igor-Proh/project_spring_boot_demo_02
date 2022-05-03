package com.prokhnov.springboot.cruddemo.service;

import com.prokhnov.springboot.cruddemo.dao.EmployeeRepository;
import com.prokhnov.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {

        if (employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id).get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
