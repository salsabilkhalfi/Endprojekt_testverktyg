package com.example.spring_thymeleaf.selenium.pages;

import org.openqa.selenium.By;

public class TodoPage extends BasePage {

    private final By searchField = By.id("input-search");
    private final By searchButton = By.id("search-button");
    private final By todos = By.className("todo-list");

    public void inputSearchQuery(String searchQuery){
        sendKeys(searchField, searchQuery);
    }

    public void submitSearchQuery(){
        click(searchButton);
    }

    public int getNumberOfTodosPresent(){
        return driver.findElements(todos).size();
    }

}
