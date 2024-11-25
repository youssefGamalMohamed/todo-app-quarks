package com.youssef.gamal;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TodoRepository implements PanacheRepository<TodoItem> {

    public List<TodoItem> getAll() {
        return listAll();
    }

    public TodoItem findById(Long id) {
        return find("id", id).firstResult();
    }

    public TodoItem create(TodoItem todoItem) {
        persist(todoItem);
        return todoItem;
    }

    public TodoItem update(Long id, TodoItem todoItem) {
        TodoItem existingTodo = findById(id);
        if (existingTodo != null) {
            existingTodo.setTask(todoItem.getTask());
            existingTodo.setCompleted(todoItem.isCompleted());
            return existingTodo;
        }
        return null;
    }

    public boolean delete(Long id) {
        TodoItem todoItem = findById(id);
        if (todoItem != null) {
            delete(todoItem);
            return true;
        }
        return false;
    }
}
