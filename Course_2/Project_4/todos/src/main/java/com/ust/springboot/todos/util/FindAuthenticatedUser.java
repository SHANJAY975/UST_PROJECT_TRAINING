package com.ust.springboot.todos.util;

import com.ust.springboot.todos.entity.User;

public interface FindAuthenticatedUser {
    User getAuthenticatedUser();
}
