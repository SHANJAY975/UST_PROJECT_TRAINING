package com.ust.springboot.todos.service;


import com.ust.springboot.todos.request.AuthenticationRequest;
import com.ust.springboot.todos.request.RegisterRequest;
import com.ust.springboot.todos.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
    AuthenticationResponse login(AuthenticationRequest request);
}
