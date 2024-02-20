package org.example;

public class TestClass2 {
    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("BeforeSuite method of TestClass2");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("AfterSuite method of TestClass2");
    }

    @Test(priority = 3)
    public static void testMethod1() {
        System.out.println("TestMethod1 of TestClass2");
    }

    @Test(priority = 7)
    public static void testMethod2() {
        System.out.println("TestMethod2 of TestClass2");
    }
}
