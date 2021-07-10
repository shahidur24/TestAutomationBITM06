package com.exam.regdataprovider;

import com.exam.logout.TestLogout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Random;

public class RegistrationByDP {
    WebDriver driver;
    //String BaseURLLogin = "https://demo.opencart.com/index.php?route=account/login";
    String BaseURLReg = "https://demo.opencart.com/index.php?route=account/register";

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

    @DataProvider(name = "RegData")
    public Object[][] regData() {
        Object[][] data = new Object[1][6]; //Rc,Row,Column
        //set1
        data[0][0] = "Shahidur";
        data[0][1] = "Ranman";
        data[0][2] = "@mail.com";
        data[0][3] = "123456";
        data[0][4] = "123456";
        data[0][5] = "123456";
        //set2
//        data[0][0] = "Shahidur";
//        data[0][1] = "Ranman";
//        data[0][2] = "@mail.com";
//        data[0][3] = "123456";
//        data[0][4] = "123456";
//        data[0][5] = "123456";
        return data;
    }

    @BeforeClass
    public void browserConfig1() {
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//main//resources//chromedriver.exe");
        //System.setProperty();
        System.setProperty("webdriver.chrome.driver", "G:\\Tutorials\\TestingQA_BITM\\TestingSoftware\\chromedriver_win32\\chromedriver.exe");
    }

    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }

    @AfterMethod
    public void closeBrowser3() {
        driver.quit();
    }

    @AfterClass
    public void browserConfig4() {
        System.out.println("Test done");
    }

    //login
//    @Test(dataProvider = "LoginData")
//    public void loginTest(String DP_Email, String DP_Pass) {
//
//        driver.get(BaseURL);
//        WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
//        WebElement Password = driver.findElement(By.xpath("//input[@id='input-password']"));
//        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
//        // Action
//        //Email
//        Email.clear();
//        //Email.sendKeys("email@mail.com");
//        Email.sendKeys(DP_Email);
//        //Password
//        Password.clear();
//        //Password.sendKeys("123456");
//        Password.sendKeys(DP_Pass);
//
//        //Login Button
//        LoginBtn.click();
//
//
//        // If Login--> Test failed
//        String Exp_Title = "Account Login";
//        String Act_Title = driver.getTitle();
//
//        //step 3: Compare
//        if (Exp_Title.equals(Act_Title)) {
//            System.out.println("Test PASSED!! for InValid test Data");
//        } else {
//            System.out.println("Test Failed!! for InValid test Data");
//        }
//        System.out.println("Test Case 001 Executed");
//
//
//    }

    // reg
    protected String name() {
        String SALTCHAR = "abcdefghijABCDEFGH123";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    //TestCast invalidRegistration
    @Test(dataProvider = "RegData")
    public void invalidRegistration(String firstNamep,String lastNamep,String emailp, String telephonep,String passwordp,String confirmPasswordp) {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.clear();
        firstName.sendKeys("Shahidur");
        lastName.clear();
        lastName.sendKeys("Rahman");
        email.clear();
        //email.sendKeys(name()+"@gmail.com");
        email.sendKeys("");
        telephone.clear();
        telephone.sendKeys("123456");
        password.clear();
        password.sendKeys("123456");
        confirmPassword.clear();
        confirmPassword.sendKeys("123456");

        if (!privacyCheckbox.isSelected()) {
            privacyCheckbox.click();
        } else {

        }

        continueButton.click();

        String Exp_Title = "Register Account";
        String Act_Title = driver.getTitle();

        //step 3: Compare
        if (Exp_Title.equals(Act_Title)) {
            System.out.println("Test PASSED!! for InValid test Data");
        } else {
            System.out.println("Test Failed!! for InValid test Data");
        }
    }


//TestCast validRegistration
    @Test(dataProvider = "RegData")
    public void validRegistration(String firstNamep,String lastNamep,String emailp, String telephonep,String passwordp,String confirmPasswordp) {
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        firstName.clear();
        firstName.sendKeys(firstNamep);
        lastName.clear();
        lastName.sendKeys(lastNamep);
        email.clear();
        email.sendKeys(name() + emailp);
        telephone.clear();
        telephone.sendKeys(telephonep);
        password.clear();
        password.sendKeys(passwordp);
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPasswordp);
        if (!privacyCheckbox.isSelected()) {
            privacyCheckbox.click();
        } else {

        }

        continueButton.click();

        String Exp_Title = "Your Account Has Been Created!";
        String Act_Title = driver.getTitle();

        //step 3: Compare
        if (Exp_Title.equals(Act_Title)) {
            System.out.println("TestCase PASSED!! for Valid test Data");
        } else {
            System.out.println("TestCase Failed!! for Valid test Data");
        }

       // TestLogout.logOut();
    }


}
