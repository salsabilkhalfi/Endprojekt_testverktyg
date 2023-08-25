package com.example.spring_thymeleaf.selenium.Pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {
  private final  By addNewAddNewLapTime = By.id("addtodo-button");


    public AddNewLapTime addNewLapTimeButton(){
        click(addNewAddNewLapTime);
        return new AddNewLapTime();
    }
}

