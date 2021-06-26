package com.exam.alert;

import com.exam.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllAboutAlert extends TestBase {
    public static void main(String[] args) {
        //firefoxLaunch();
        chromeLaunch();
        openURL("https://the-internet.herokuapp.com/javascript_alerts");
        normalJSAlert();
        confirmJSAlert();
        promptJSAlert();
    }
    public static  void normalJSAlert(){
        WebElement normalAlertBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        normalAlertBtn.click();
        //title
        String alertTitle = driver.switchTo().alert().getText();
        System.out.println("normal alert Title : "+alertTitle);

        //click ok
        driver.switchTo().alert().accept();

    }

    public static  void confirmJSAlert(){
        WebElement confirmAlertBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        confirmAlertBtn.click();
        //title
        String alertTitle = driver.switchTo().alert().getText();
        System.out.println("Confirm alert Title: "+alertTitle);

        //click ok
        driver.switchTo().alert().accept();

        //click cancel
        //driver.switchTo().alert().dismiss();
    }
    public static  void promptJSAlert(){
        WebElement promptAlertBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        promptAlertBtn.click();
        //title
        String alertTitle = driver.switchTo().alert().getText();
        System.out.println("Prompt alert Title: "+alertTitle);


        //write
        driver.switchTo().alert().sendKeys("Test Automation.");
        //click ok
        driver.switchTo().alert().accept();

        //click cancel
        //driver.switchTo().alert().dismiss();
    }
}
