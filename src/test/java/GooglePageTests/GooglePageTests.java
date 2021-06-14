package GooglePageTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class GooglePageTests {

    private static ChromeDriver webDriver;
    private final static Logger logger = Logger.getLogger(GooglePageTests.class);


    @Before
    public void setup() {
        try {
            logger.info("Test starting...");

            File fileChromeDriver = new File("C:\\chromedriver/chromedriver.exe");
            webDriver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
            logger.info("Driver was loaded");

            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            webDriver.get("https://www.google.com.ua");
            logger.info("Opening google page...");

        } catch (Exception e) {
            logger.info("Mistake massage: ", e);
        }

    }

    @After
    public void tearDown(){
        //Close webDriver
        webDriver.quit();
        logger.info("Browser was closed");
    }

    @Test
    public void findTextOnGooglePageTest() {
        webDriver.findElement(By.cssSelector("[name=\"q\"]")).sendKeys("junit4");
        webDriver.findElement(By.cssSelector(".gNO89b")).click();
        logger.info("Seaching junit4 text");

        WebElement webElement1 = webDriver.findElement(By.xpath("//a[@href='https://junit.org/junit4/']/h3[@class='LC20lb DKV0Md']"));
        String actualTitle = webElement1.getText();
        logger.info("Finding title Junit - about");

        WebElement webElement2 = webDriver.findElement(By.xpath("//a[@href='https://junit.org/junit4/']"));
        String actualLink = webElement2.getAttribute("href");
        logger.info("Finding link https://junit.org/junit4/");

        Assert.assertEquals("About - JUnit", actualTitle);
        logger.info("Title is correct");
        Assert.assertEquals("https://junit.org/junit4/", actualLink);
        logger.info("Link is correct");

    }

}