package com.ust.springboot.todos.controller;

import com.ust.springboot.todos.entity.User;
import com.ust.springboot.todos.request.PasswordUpdateRequest;
import com.ust.springboot.todos.response.UserResponse;
import com.ust.springboot.todos.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User REST API Endpoints", description = "Operations related to info about current user")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public UserResponse getUserInfo(){
        return userService.getUserInfo();
    }

    @DeleteMapping
    public void deleteUser(){
        userService.deleteUser();
    }

    @PutMapping("/password")
    public void updatePassword(@Valid @RequestBody PasswordUpdateRequest passwordUpdateRequest) throws Exception{
        userService.updatePassword(passwordUpdateRequest);
    }

}
