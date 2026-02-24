package com.ust.springboot.employees.service;

import com.ust.springboot.employees.dao.EmployeeDAO;
import com.ust.springboot.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
