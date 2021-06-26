//package com.exam.screenshot;
//
//import com.exam.base.TestBase;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.io.File;
//import java.io.IOException;
//
//public class PageScreenShots extends TestBase {
//    public static void main(String[] args) throws IOException {
//        chromeLaunch();
//        openURL("https://google.com");
//        screenshot();
//        closeBrowser();
//    }
//
//    public static void screenshot() throws IOException {
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        //FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "src//main//resources//screenshots//" + "name" + ".png"));
//        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "src//main//resources//screenshots//" + "name" + ".png"));
//    System.out.println("ok");
//    }
//}
