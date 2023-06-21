package com.example.spring_thymeleaf.controller;

import com.example.spring_thymeleaf.dto.CreateTodoDTO;
import com.example.spring_thymeleaf.entities.Todo;
import com.example.spring_thymeleaf.service.TodoService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String findAll(
            @RequestParam(required = false, defaultValue = "", name = "tcon") String contains,
            Model model
    ){
        List<Todo> todoList = todoService.findAll(contains);
        model.addAttribute("todoList", todoList);
        return "todo";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Todo> findById(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(todoService.findById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public String addTodo(@ModelAttribute CreateTodoDTO createTodoDTO, HttpServletResponse httpServletResponse){
        Todo todo = todoService.addTodo(createTodoDTO.title(), createTodoDTO.description());
        httpServletResponse.setHeader("id", String.valueOf(todo.getId()));
        return "redirect:/todo";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        try {
            todoService.deleteById(id);
            return ResponseEntity.status(303).header("Location", "/todo").build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(404).header("Location", "/todo").build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
            todoService.deleteAll();
            return ResponseEntity.status(204).header("Location", "/todo").build();
    }

}
