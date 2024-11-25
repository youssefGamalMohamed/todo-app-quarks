package com.youssef.gamal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TodoItem extends PanacheEntity {

    public String task;
    public boolean completed;

    // Constructors, getters, and setters
    public TodoItem() {}

    public TodoItem(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
