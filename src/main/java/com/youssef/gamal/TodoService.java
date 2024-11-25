package com.youssef.gamal;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TodoService {

    @Inject
    TodoRepository todoRepository;

    public List<TodoItem> getAllTodos() {
        return todoRepository.getAll();
    }

    public TodoItem getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public TodoItem createTodo(TodoItem todoItem) {
        return todoRepository.create(todoItem);
    }

    public TodoItem updateTodo(Long id, TodoItem todoItem) {
        return todoRepository.update(id, todoItem);
    }

    public boolean deleteTodo(Long id) {
        return todoRepository.delete(id);
    }
}
