package com.exam.browseroption;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeadlessTest {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\chromedriver_win32\\chromedriver.exe");
        //set driver path dynamic
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//main//resources//chromedriver.exe");
        ChromeOptions obj = new ChromeOptions();
        obj.setHeadless(true);
        driver = new ChromeDriver(obj);
        //driver.get("https://demo.opencart.com/index.php?route=account/login");

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
        System.out.println("Headless test done "+title);
    }
}
