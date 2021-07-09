package com.exam.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DP_LoginTest {
    WebDriver driver;
    String BaseURL = "https://demo.opencart.com/index.php?route=account/login";

    @DataProvider(name = "LoginData")
    public Object[][] data() {
        Object[][] data = new Object[3][2]; //Rc,Row,Column
        //set1
        data[0][0] = "mail@mail.com";
        data[0][1] = "mail@mail.com";
        //set2
        data[1][0] = "mail2@mail.com";
        data[1][1] = "";
        //set3
        data[2][0] = "";
        data[2][1] = "123456";
        return data;
    }
    @BeforeClass
    public void browserConfig1(){
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//main//resources//chromedriver.exe");
        //System.setProperty();
        System.setProperty("webdriver.chrome.driver","G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\chromedriver_win32\\chromedriver.exe");
    }
    @BeforeMethod
    public void launchBrowser(){
        driver=new ChromeDriver();
    }
    @AfterMethod
    public void closeBrowser3(){
        driver.quit();
    }
    @AfterClass
    public void browserConfig4(){
        System.out.println("Test done");
    }
    @Test(dataProvider="LoginData")
    public void loginTest(String DP_Email,String DP_Pass){

       driver.get(BaseURL);
        WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement Password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        // Action
        //Email
        Email.clear();
        //Email.sendKeys("email@mail.com");
        Email.sendKeys(DP_Email);
        //Password
        Password.clear();
        //Password.sendKeys("123456");
        Password.sendKeys(DP_Pass);

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


}
