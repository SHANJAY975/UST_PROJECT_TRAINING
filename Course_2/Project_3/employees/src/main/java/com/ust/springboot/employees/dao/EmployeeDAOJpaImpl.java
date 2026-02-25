package com.ust.springboot.employees.dao;

import com.ust.springboot.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements  EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a Query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        //Execute the Query
        List<Employee> theresults = query.getResultList();

        //return the result
        return theresults;
    }

    @Override
    public Employee findById(long theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee= entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(long theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        entityManager.remove(employee);

    }
}
