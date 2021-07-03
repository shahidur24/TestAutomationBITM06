package com.exam.testNGDemo;

import org.testng.annotations.*;

public class BaseTestNG {
    @BeforeSuite
    public static void beforeSuiteTest(){
        System.out.println("i am from BaseTestNG @BeforeSuite");
    }
    @AfterSuite
    public static void afterSuiteTest(){
        System.out.println("i am from BaseTestNG @AfterSuite");
    }
//    @Test
//    public static void test_BaseTestNG(){
//        System.out.println("i am from TestCase BaseTestNG");
//    }

}
