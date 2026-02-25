package com.ust.springboot.employees.service;

import com.ust.springboot.employees.dao.EmployeeRepository;
import com.ust.springboot.employees.entity.Employee;
import com.ust.springboot.employees.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO) {
        this.employeeRepository = employeeDAO;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee =  result.get();
        }
        else{
            throw new RuntimeException("Employee Not Found- ID:"+theId);
        }
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest theEmployeeRequest) {
        Employee employee = convertToEmployee(0, theEmployeeRequest);
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        Employee updatedEmployee = convertToEmployee(id, employeeRequest);
        return employeeRepository.save(updatedEmployee);
    }


    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(id, employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}
