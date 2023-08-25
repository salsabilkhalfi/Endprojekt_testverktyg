package com.example.spring_thymeleaf.selenium.SeleniumTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;



    public class AddLapTimeTest extends BaseTest {



            @Test
            public void testAddNewLapTime() {
                // Find and click the add button
                WebElement addButton = driver.findElement(By.id("addtodo-button"));
                addButton.click();

                // Input field
                WebElement inputField = driver.findElement(By.id("input-laptime"));
                inputField.sendKeys("1");

                // Find and click the save button
                WebElement saveButton = driver.findElement(By.id("save-button"));
                saveButton.click();


                WebElement lapTimesList = driver.findElement(By.id("lapTime-list"));
                String listContent = lapTimesList.getText();
                assertEquals("1", listContent);
            }
        }
