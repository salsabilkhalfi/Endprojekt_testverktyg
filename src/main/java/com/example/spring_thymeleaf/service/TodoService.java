package com.example.spring_thymeleaf.service;

import com.example.spring_thymeleaf.entities.Todo;
import com.example.spring_thymeleaf.repo.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> findAll(String contains) {

        if(contains.isBlank())
            return todoRepo.findAll();

        return todoRepo.findTodosByTitleContainsIgnoreCase(contains);
    }

    public Todo findById(int id) {
        return todoRepo.findById(id).orElseThrow();
    }

    public Todo addTodo(String title, String description) {
        return todoRepo.save(new Todo(title, description));
    }

    public void deleteById(int id) {
        todoRepo.deleteById(id);
    }

    public void deleteAll() {
        todoRepo.deleteAll();
    }
}
