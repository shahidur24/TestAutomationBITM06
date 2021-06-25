package com.exam;

import com.exam.base.TestBase;

public class TestNavigate extends TestBase {
    public static void main(String[] args) {
        chromeLaunch();
        openURL("https://demo.opencart.com/");
        driver.navigate().to("https://google.com");
        navigateBack();
        navigateForward();
        pageRefresh();
        closeBrowser();

    }
    public static void navigateBack(){
        driver.navigate().back();
        String exp_title="Your Store";
        String act_title=driver.getTitle();
        if(exp_title.equals(act_title)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

    }
    public static void navigateForward(){
        driver.navigate().forward();
        String exp_title="Google";
        String act_title=driver.getTitle();
        if(exp_title.equals(act_title)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }
    public static void pageRefresh(){
        driver.navigate().refresh();
        System.out.println("Page Refreshed");

    }
}
