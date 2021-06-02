package vkucheruk.thirdLesson;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    public ChromeDriver webDriver;
//  private final static Logger logger = Logger.getLogger(RegistrationTest.class);

    @Test
    public void testRegistrationValid(){
        File chromeFF;
        chromeFF = new File("C:\\chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ((File) chromeFF).getAbsolutePath());

    webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    //MAIN PAGE
    webDriver.get("http://automationpractice.com");

    //CLICK ON THE SUBMITE BUTTON
    webDriver.findElement(By.xpath("//a[@class='login']")).click();    //div[@class='header_user_info']

    //SENDING EMAIL PAGE
    webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("vita6.kucheruk@gmail.com");
    webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

    //YOUR PERSONAL INFORMATION
    webDriver.findElement(By.xpath("//form[@id='account-creation_form']/div[@class='account_creation']/div[@class='clearfix']/div[2]")).click();
    webDriver.findElement(By.id("customer_firstname")).sendKeys("Vita");
    webDriver.findElement(By.id("customer_lastname")).sendKeys("Kucheruk");
//  webDriver.findElement(By.id("email")).sendKeys("vitabb6.kucheruk@gmail.com");
    webDriver.findElement(By.id("passwd")).sendKeys("kkll;mkl");
    webDriver.findElement(By.id("newsletter")).click();
    webDriver.findElement(By.id("optin")).click();

    //YOUR ADDRESS
    webDriver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Vita");
    webDriver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Kucheruk");
    webDriver.findElement(By.id("address1")).sendKeys("-, 01526, Company name, etc.");
    webDriver.findElement(By.id("city")).sendKeys("Brovary");

    webDriver.findElement(By.id("uniform-id_state")).click();
  // webDriver.findElement(By.xpath("//p[@class='required id_state select form-group']/div[@id='uniform-id_state']/[@checked]/span[@text='Alabama']")).click();
    Select state = new Select(webDriver.findElement(By.id("id_state")));
    state.selectByVisibleText("Alabama");

    webDriver.findElement(By.id("postcode")).sendKeys("01526");

    webDriver.findElement(By.id("id_country")).isDisplayed();
    Select country = new Select(webDriver.findElement(By.id("id_country")));
    country.selectByVisibleText("United States");

    webDriver.findElement(By.id("phone_mobile")).sendKeys("+051562566155");
    webDriver.findElement(By.id("alias")).sendKeys("hello");
    webDriver.findElement(By.id("submitAccount")).click();



  //  webDriver.close();




    }


}
