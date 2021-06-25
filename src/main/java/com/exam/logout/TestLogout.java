package com.exam.logout;

import com.exam.base.TestBase;
import com.exam.login.TestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestLogout extends TestBase{
    public static void main(String[] args)  {
        chromeLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/login");
        TestLogin.TC_Login_Valid_002();
        System.out.println("Login success");

        logOut();

        closeBrowser();
        System.out.println("browser closed");
    }
    public static void logOut(){
        WebElement myAccount=driver.findElement(By.linkText("My Account"));
        WebElement logout=driver.findElement(By.linkText("Logout"));

        myAccount.click();
        logout.click();

        System.out.println("Logout Success");
    }
}
