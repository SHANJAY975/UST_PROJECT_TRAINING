package com.ust.springboot.todos.service;

import com.ust.springboot.todos.entity.Authority;
import com.ust.springboot.todos.entity.User;
import com.ust.springboot.todos.repository.UserRepository;
import com.ust.springboot.todos.request.RegisterRequest;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void register(RegisterRequest input) throws Exception {
        if(isEmailTaken(input.getEmail())){
            throw new Exception("Email already Taken");
        }
        User user = buildNewUser(input);
        userRepository.save(user);
    }

    private boolean isEmailTaken(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    private User buildNewUser(RegisterRequest input) {
        User user = new User();
        user.setId(0);
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setAuthorities(initialAuthority());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        return user;
    }

    private List<Authority> initialAuthority(){
        boolean isFirstUser = userRepository.count() == 0;
        List<Authority> authorities = new ArrayList<>();
        authorities.add(new Authority("ROLE_EMPLOYEE"));
        if(isFirstUser){
            authorities.add(new Authority("ROLE_ADMIN"));
        }
        return authorities;
    }
}
