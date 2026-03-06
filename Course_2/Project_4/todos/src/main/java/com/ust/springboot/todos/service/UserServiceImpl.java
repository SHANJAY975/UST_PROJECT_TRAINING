package com.ust.springboot.todos.service;

import com.ust.springboot.todos.entity.Authority;
import com.ust.springboot.todos.entity.User;
import com.ust.springboot.todos.repository.UserRepository;
import com.ust.springboot.todos.request.PasswordUpdateRequest;
import com.ust.springboot.todos.response.UserResponse;
import com.ust.springboot.todos.util.FindAuthenticatedUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, FindAuthenticatedUser findAuthenticatedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserInfo() {

        User user =  findAuthenticatedUser.getAuthenticatedUser();

        return new UserResponse(user.getId(),
                user.getFirstName()+" "+user.getLastName(),
                user.getEmail(),
                user.getAuthorities().stream().map((authority)-> (Authority) authority).toList());
    }

    @Override
    public void deleteUser() {
        User user =  findAuthenticatedUser.getAuthenticatedUser();

        // isLastAdmin check
        if(isLastAdmin(user)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Admin cannot delete itself");
        }

        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void updatePassword(PasswordUpdateRequest request) {
        User user = findAuthenticatedUser.getAuthenticatedUser();
        if(!isOldPasswordCorrect(user.getPassword(), request.getOldPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Current Password is incorrect");
        }

        if(!isNewPasswordConfirmed(request.getNewPassword(), request.getNewPassword1())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Passwords does not match");
        }
        if(!isNewPasswordDifferent(request.getOldPassword(), request.getNewPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Password must be different");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }



    private boolean isOldPasswordCorrect(String currentPassword, String oldPassword){
        return passwordEncoder.matches(oldPassword, currentPassword);
    }

    private boolean isNewPasswordConfirmed(String newPassword1, String newPassword2){
        return newPassword1.equals(newPassword2);
    }

    private boolean isNewPasswordDifferent(String oldPassword, String newPassword){
        return !oldPassword.equals(newPassword);
    }

    private boolean isLastAdmin(User user){
        boolean isAdmin = user.getAuthorities().stream()
                .anyMatch((authority)-> "ROLE_ADMIN".equals(authority.getAuthority()));

        if(isAdmin){
            long adminCount = userRepository.countAdminUsers();
            return adminCount<=1;
        }
        return false;
    }
}
