package com.ust.springboot.todos.service;


import com.ust.springboot.todos.request.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
}
