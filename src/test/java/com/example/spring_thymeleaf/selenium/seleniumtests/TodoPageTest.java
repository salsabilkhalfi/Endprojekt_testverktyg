package com.example.spring_thymeleaf.selenium.seleniumtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext
public class TodoPageTest extends BaseTest {

    @Test
    @Sql({"classpath:import_todos.sql"})
    public void displayAllTodos() throws InterruptedException {
        // Given
        String searchQuery = "";

        // When
        todoPage.inputSearchQuery(searchQuery);
        todoPage.submitSearchQuery();

        // Then
        assertDisplayedEqualsInputedMessage(3);

    }

    @Test
    @Sql({"classpath:import_todos.sql"})
    public void searchQueryShouldFilterResults() throws InterruptedException {
        // Given
        String searchQuery = "Gör klart 1";

        // When
        todoPage.inputSearchQuery(searchQuery);
        todoPage.submitSearchQuery();

        // Then
        assertDisplayedEqualsInputedMessage(1);

    }

    private void assertDisplayedEqualsInputedMessage(int number) {
        Assertions.assertEquals(todoPage.getNumberOfTodosPresent(), number);
    }


}
