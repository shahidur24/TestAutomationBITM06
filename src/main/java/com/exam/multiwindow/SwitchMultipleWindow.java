package com.exam.multiwindow;

import com.exam.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;


public class SwitchMultipleWindow extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openURL("http://google.com");
        switchWindow();
        closeBrowser();
    }
    public static void switchWindow(){
        //Assign parent GUID
        String parentGUID = driver.getWindowHandle();
        String parentTitle = driver.getTitle();
        System.out.println(parentGUID);

        WebElement childWindow = driver.findElement(By.cssSelector("dfd"));
        childWindow.click();

        //Get All GUID
        Set<String> allGUID = driver.getWindowHandles();

        //Switch to child
        for(String childGUID:allGUID){
           driver.switchTo().window(childGUID);
           driver.navigate().to("");
           String parentSecondTitle = driver.getTitle();
           System.out.println("");
           break;
        }
        //Switch to parent
        for(String childGUID:allGUID){
            driver.switchTo().window(childGUID);
            driver.navigate().to("");
            String parentSecondTitle = driver.getTitle();
            System.out.println("");
            break;
        }
    }
}
