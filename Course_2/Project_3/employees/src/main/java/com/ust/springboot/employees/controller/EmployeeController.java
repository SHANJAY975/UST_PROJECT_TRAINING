package com.ust.springboot.employees.controller;

import com.ust.springboot.employees.dao.EmployeeDAO;
import com.ust.springboot.employees.entity.Employee;
import com.ust.springboot.employees.request.EmployeeRequest;
import com.ust.springboot.employees.service.EmployeeService;
import com.ust.springboot.employees.service.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Rest API Endpoints", description="Operations related to Employees")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get all Employees", description = "Retrieve all the Employees ")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @Operation(summary = "Fetch single Employee", description = "Get a single employee from database")
    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public  Employee getEmployee(@PathVariable @Min(value = 1) long employeeId){
        Employee employee = employeeService.findById(employeeId);
        return  employee;
    }


    @Operation(summary = "Create a New Employee", description = "Add new employee to the database")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid EmployeeRequest theEmployeeRequest){
        Employee dbEmployee = employeeService.save(theEmployeeRequest);
        return  dbEmployee;
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update Employee", description = "Update the details of employee with id")
    public Employee updateEmployee(@PathVariable @Min(value = 1) long employeeId,
                                   @RequestBody @Valid EmployeeRequest theEmployeeRequest){
        Employee updatedEmployee = employeeService.update(employeeId, theEmployeeRequest);
        return updatedEmployee;
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete employee", description = "Delete the current employee using id")
    public void deleteEmployee(@PathVariable @Min(value = 1) long employeeId){
        employeeService.deleteById(employeeId);
    }
}
