package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TaskController {
    @QueryMapping
    public Task taskById(@Argument String id) {
        return Task.getById(id);
    }

    @SchemaMapping
    public User user(Task task) {
        return User.getById(task.userId());
    }

    @QueryMapping
    public List<Task> taskList(@Argument String id) {
        return Task.getList();
    }
}