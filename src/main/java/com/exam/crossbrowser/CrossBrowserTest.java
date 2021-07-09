package com.exam.crossbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
    WebDriver driver;

    String FirefoxdriverPath = "G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\geckodriver-v0.29.1-win64\\geckodriver.exe";
    String ChromeDriverPath = "G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\chromedriver_win32\\chromedriver.exe";
    String BaseURL = "https://demo.opencart.com/index.php?route=account/login";

    @BeforeTest
    @Parameters("Browser")
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\geckodriver-v0.29.1-win64\\geckodriver.exe");

            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            throw new Exception("no");
        }
    }

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

    @Test(dataProvider = "LoginData")
    public void loginTest(String DP_Email, String DP_Pass) {

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

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        System.out.println("AfterTest done");
    }


}
