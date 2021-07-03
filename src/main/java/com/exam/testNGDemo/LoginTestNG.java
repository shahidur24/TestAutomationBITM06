package com.exam.testNGDemo;

import com.exam.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestNG{
    public static WebDriver driver;

    @BeforeClass
    public  void setup() {
        System.setProperty("webdriver.chrome.driver","G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\chromedriver_win32\\chromedriver.exe");
        //set driver path dynamic
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
@Test
    public static void TC_Login_Invalid_001() {
        WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action
        //Email
        Email.clear();
        Email.sendKeys("email@mail.com");

        //Password
        Password.clear();
        Password.sendKeys("123456");

        //Login Button
        LoginBtn.click();


        // If Login--> Test failed
        String Exp_Title = "Account Login";
        String Act_Title = driver.getTitle();

        //step 3: Compare
        if (Exp_Title.equals(Act_Title)) {
            System.out.println("Test PASSED!! for InValid test Data");
        } else {
            System.out.println("Test Failed!! for InValid test Data");
        }
        System.out.println("Test Case 001 Executed");
    }
    @Test
    public static void TC_Login_Valid_002() {
        WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action
        Email.clear();
        Email.sendKeys("G3eDdia2C1@gmail.com");
        Password.clear();
        Password.sendKeys("123456");
        LoginBtn.click();

        // If Login--> Test Passed
        // Else --> Test Failed
        // If Login--> Test failed
        String Exp_Title = "Account Login";
        String Act_Title = driver.getTitle();

        //step 3: Compare
        if (!Exp_Title.equals(Act_Title)) {
            System.out.println("Test PASSED!! for Valid test Data");
        } else {
            System.out.println("Test FAILED!! for Valid test Data");
        }
        System.out.println("Test Case 002 Executed");
    }


}
