package com.prokhnov.springboot.cruddemo.dao;

import com.prokhnov.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        if (employee == null) {
            throw new RuntimeException("Id not found");
        }

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteEmployee(int id) {

        Query query = entityManager.createQuery("delete from Employee where id=: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
