package com.ust.springboot.todos.service;

import com.ust.springboot.todos.request.PasswordUpdateRequest;
import com.ust.springboot.todos.response.UserResponse;

public interface UserService {
    UserResponse getUserInfo();
    void deleteUser();
    void updatePassword(PasswordUpdateRequest request);
}
