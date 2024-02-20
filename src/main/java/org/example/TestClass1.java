package org.example;

public class TestClass1 {
    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("BeforeSuite method of TestClass1");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("AfterSuite method of TestClass1");
    }

    @Test(priority = 5)
    public static void testMethod1() {
        System.out.println("TestMethod1 of TestClass1");
    }

    @Test(priority = 10)
    public static void testMethod2() {
        System.out.println("TestMethod2 of TestClass1");
    }

    @Test(priority = 1)
    public static void testMethod3() {
        System.out.println("TestMethod3 of TestClass1");
    }
}
