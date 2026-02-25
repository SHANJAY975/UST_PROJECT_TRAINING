package com.ust.springboot.employees.request;

import jakarta.validation.constraints.*;

public class EmployeeRequest {

    @NotBlank(message = "FirstName is Mandatory")
    @Size(min = 2, max = 50, message = "FirstName Must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "LastName is Mandatory")
    @Size(min = 2, max = 50, message = "LastName Must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Email is Mandatory")
    @Email(message = "Please provide a valid Email address")
    private String email;

    public EmployeeRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
