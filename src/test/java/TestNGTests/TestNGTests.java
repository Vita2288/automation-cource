package TestNGTests;


import org.junit.Assert;
import org.testng.annotations.*;

public class TestNGTests {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass TestNG");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass TestNG");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod TestNG");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod TestNG");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void TestNG(){
        System.out.println("Test TestNG");
        Assert.assertEquals("Expected value", "expected res", "actual res");
    }
}
