package com.exam.testNGDemo;

import org.testng.annotations.*;

public class TC_001 extends  BaseTestNG
{
    @BeforeMethod
    public static void beforeSuite() {
        System.out.println("i am from TC_001 @BeforeMethod");
    }

    @AfterMethod
    public static void afterSuite() {
        System.out.println("i am from TC_001 @afterMethod");
    }

    @Test
    public static void test_001() {
        System.out.println("i am from TestCase TC_001");
    }
    @Test
    public static void test_0011() {
        System.out.println("i am from TestCase TC_0011");
    }
}
