package com.ust.springboot.employees.dao;

import com.ust.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(long id);

    Employee save(Employee theEmployee);
    void deleteById(long id);
}
