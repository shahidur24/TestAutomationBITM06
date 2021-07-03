package com.exam.browseroption;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuthentication {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\chromedriver_win32\\chromedriver.exe");
        //set driver path dynamic
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
@Test
    public void basicAuthentication() {
        driver.get("https://admin:admin@the-internet.herokuapp.com");
        String title = driver.getTitle();
        System.out.println(title);
    }
}
