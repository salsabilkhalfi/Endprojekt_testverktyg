package com.example.spring_thymeleaf;

import com.example.spring_thymeleaf.entities.Todo;
import com.example.spring_thymeleaf.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringThymeleafApplication{
    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

}
