package JunitTests;

import org.junit.*;

public class JUnit4Tests {
    @BeforeClass
    public static  void BeforeClass(){
        System.out.println("Before class Junit");
    }

    @Before
    public  void Before(){
        System.out.println("Before Junit");
    }

    @After
    public static void After(){
        System.out.println("After Junit");
    }

    @Test
    public  void Test1(){
        System.out.println("Test1 Junit");
        Assert.assertEquals("Expected value", "expected res", "actual res");
    }

    @Test(timeout = 1000)
    public  void Test2(){
        System.out.println("Test2 Junit");
        Assert.assertEquals("Expected value", "expected res", "actual res");
    }
}
