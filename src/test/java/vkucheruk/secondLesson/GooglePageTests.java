package vkucheruk.secondLesson;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GooglePageTests {

    private static ChromeDriver webDriver;
    private final static Logger logger = Logger.getLogger(GooglePageTests.class);

    @Test
    public static void main(String[] args) {
        try {
            logger.info("Test starting...");

            File fileChromeDriver = new File("C:\\chromedriver/chromedriver.exe");
            webDriver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
            logger.info("Driver was loaded");

            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            logger.info("Opening google page...");
            webDriver.get("https://www.google.com.ua");


            webDriver.findElement(By.xpath("/.//*[text()='Google']"));
            webDriver.findElement(By.cssSelector("[name=\"q\"]")).sendKeys("maven selenium java");
            webDriver.findElement(By.cssSelector(".gNO89b")).click();


            logger.info("Page was opened!");
            webDriver.quit();

        } catch (Exception e) {
            logger.warn("Something was wrong: ", e);
        }

    }
}