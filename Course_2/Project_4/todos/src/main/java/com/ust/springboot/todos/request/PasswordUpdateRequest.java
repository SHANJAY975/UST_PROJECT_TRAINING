package com.ust.springboot.todos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PasswordUpdateRequest {
    @NotEmpty(message = "Old Password is mandatory")
    @Size(min = 5, max = 30, message = "Old Password must be at least 5 characters long")
    private String oldPassword;

    @NotEmpty(message = "New Password is mandatory")
    @Size(min = 5, max = 30, message = "New Password must be at least 5 characters long")
    private String newPassword;
    @NotEmpty(message = "Confirmed Password is mandatory")
    @Size(min = 5, max = 30, message = "Confirmed Password must be at least 5 characters long")
    private String newPassword1;

    public PasswordUpdateRequest(String oldPassword, String newPassword, String newPassword1) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPassword1 = newPassword1;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }
}
