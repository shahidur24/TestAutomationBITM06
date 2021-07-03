package com.exam.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingleFrame {
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
        //driver.quit();
    }
    @Test(description = "Single frame test")
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String title = driver.getTitle();
        System.out.println(title);

        //switch to iFrame
        driver.switchTo().frame("mce_0_ifr");

        WebElement iFrameBody=driver.findElement(By.id("tinymce"));
        iFrameBody.clear();
        iFrameBody.sendKeys("iFrame Test done.");

    }
}
