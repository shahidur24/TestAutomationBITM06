package com.exam.dropdown;

import com.exam.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllAboutDropdown extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openURL("https://the-internet.herokuapp.com/dropdown");
        selectIndex();
        selectbyvalue();
        selectVisibleText();
    }
    public static void selectIndex(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropdown);
        obj.selectByIndex(2); //index 2
    }
    public static void selectbyvalue(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropdown);
        obj.selectByValue("1"); //value

    }
    public static void selectVisibleText(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropdown);
        obj.selectByVisibleText("Option 2"); //text
    }
}
