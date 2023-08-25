package com.example.spring_thymeleaf.selenium.SeleniumTest;

import com.example.spring_thymeleaf.selenium.Pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;


public class BaseTest {
    public WebDriver driver;
    private static String baseURL = "http://localhost:8080/laptimes";
    public LandingPage landingPage;

    @BeforeAll
    public static void init(){
        // Any setup needed before all test methods run
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
        landingPage = new LandingPage();
        landingPage.setDriver(driver);
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

