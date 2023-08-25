package com.example.spring_thymeleaf.selenium.SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;


public class BaseTest {
    public WebDriver driver;
    private static String baseURL = "http://localhost:8080/laptimes";


    @BeforeAll
    public static void init(){
    }

    @BeforeEach
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // options.addArguments("--headless");
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

   // @AfterEach
    //public void quit() {
      //  if (driver != null) {
        //    driver.quit();
        //}
   // }

   // @AfterAll
    //public static void tearDownAll() {

    //}
}

