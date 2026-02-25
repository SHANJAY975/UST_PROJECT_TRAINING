package com.ust.springboot.employees.service;

import com.ust.springboot.employees.dao.EmployeeDAO;
import com.ust.springboot.employees.entity.Employee;
import com.ust.springboot.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(long theId);

    Employee save(EmployeeRequest employeeRequest);

    Employee update(long id, EmployeeRequest employeeRequest);

    Employee convertToEmployee(long id, EmployeeRequest employeeRequest);
    void deleteById(long theId);
}
