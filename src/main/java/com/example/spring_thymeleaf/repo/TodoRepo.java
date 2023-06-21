package com.example.spring_thymeleaf.repo;

import com.example.spring_thymeleaf.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

    List<Todo> findTodosByTitleContainsIgnoreCase(String contains);

}
