package com.exam.testNGDemo;

import org.testng.annotations.*;

public class TC_002 extends BaseTestNG {
    @BeforeClass
    public static void beforeSuite() {
        System.out.println("i am from TC_002 @BeforeClass");
    }

    @AfterClass
    public static void afterSuite() {
        System.out.println("i am from TC_002 @afterClass");
    }

    @Test
    public static void test_002() {
        System.out.println("i am from TestCase TC_002");
    }

    @Test
    public static void test_0022() {
        System.out.println("i am from TestCase TC_0022");
    }

}
