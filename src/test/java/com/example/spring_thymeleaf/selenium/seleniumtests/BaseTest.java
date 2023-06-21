package com.example.spring_thymeleaf.selenium.seleniumtests;

import com.example.spring_thymeleaf.selenium.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    protected WebDriver driver;
    private final String baseUrl = "http://localhost:8080/todo";
    protected TodoPage todoPage;

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        // only for moving it on multimonitor
        //driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.get(baseUrl);
        todoPage = new TodoPage();
        todoPage.setDriver(driver);
    }

}
