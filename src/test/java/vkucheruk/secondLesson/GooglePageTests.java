package vkucheruk.secondLesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GooglePageTests {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua/");
    }
}
