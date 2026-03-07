package com.ust.springboot.todos.service;

import com.ust.springboot.todos.request.TodoRequest;
import com.ust.springboot.todos.response.TodoResponse;

import java.util.List;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);
    List<TodoResponse> getAllTodos();
    TodoResponse toggleTodoCompletion(long id);
    void deleteTodo(long id);
}
