package com.exam.reg;

import com.exam.base.TestBase;
import com.exam.logout.TestLogout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class TestRegistration extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/register");
        validRegistration();
        openURL("https://demo.opencart.com/index.php?route=account/register");
        invalidRegistration();





    }
    protected static String name(){
        String SALTCHAR="abcdefghijABCDEFGH123";
        StringBuilder salt=new StringBuilder();
        Random rnd=new Random();

        while(salt.length()<10){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));
        }
        String saltStr=salt.toString();
        return saltStr;
    }

    public static void invalidRegistration() {
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

        if(!privacyCheckbox.isSelected()){
            privacyCheckbox.click();
        }else {

        }

        continueButton.click();

        String Exp_Title="Register Account";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }
    }

    public static void validRegistration() {
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
        email.sendKeys(name()+"@gmail.com");
        telephone.clear();
        telephone.sendKeys("123456");
        password.clear();
        password.sendKeys("123456");
        confirmPassword.clear();
        confirmPassword.sendKeys("123456");
        if(!privacyCheckbox.isSelected()){
            privacyCheckbox.click();
        }else {

        }

        continueButton.click();

        String Exp_Title="Your Account Has Been Created!";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("TestCase PASSED!! for Valid test Data");
        }
        else {
            System.out.println("TestCase Failed!! for Valid test Data");
        }

        TestLogout.logOut();
    }

}
