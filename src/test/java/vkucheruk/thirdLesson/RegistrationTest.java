package vkucheruk.thirdLesson;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    public ChromeDriver webDriver;
    private final static Logger logger = Logger.getLogger(RegistrationTest.class);

    @Test
    public void testRegistrationValid(){
        File chromeFF;
        chromeFF = new File("C:\\chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ((File) chromeFF).getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        try {
        //MAIN PAGE
            webDriver.get("http://automationpractice.com");
            logger.info("Open link - http://automationpractice.com");
        } catch (Exception e){
            logger.error("Can`t open browser");
            Assert.fail("Can`t open browser");
        }


        //CLICK ON THE SIGN IN BUTTON
        webDriver.findElement(By.xpath("//a[@class='login']")).click();    //div[@class='header_user_info']
        logger.info("Click on the Sign in button- //a[@class='login']");

        //SENDING EMAIL PAGE
        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("vita9.kucheruk@gmail.com");
        logger.info("Input e-mail - //input[@id='email_create']");
        webDriver.findElement(By.id("SubmitCreate")).click();
        logger.info("Click on the submit button - SubmitCreate");

        //YOUR PERSONAL INFORMATION
        webDriver.findElement(By.xpath("//form[@id='account-creation_form']/div[@class='account_creation']/div[@class='clearfix']/div[2]")).click();   //id='uniform-id_gender2']/input[id='id_gender2']")).click();
        logger.info("Click on the account create form. Click on the radio button");
        webDriver.findElement(By.id("customer_firstname")).sendKeys("Vita");
        logger.info("Input first name - customer_firstname");
        webDriver.findElement(By.id("customer_lastname")).sendKeys("Kucheruk");
        logger.info("Input last name - customer_lastname");
        webDriver.findElement(By.id("email")).getAttribute("vita9.kucheruk@gmail.com");
        logger.info("Email is visible - vita211.kucheruk@gmail.com");
        webDriver.findElement(By.id("passwd")).sendKeys("kkll;mkl");
        logger.info("Input password - passwd");
        webDriver.findElement(By.id("newsletter")).click();
        logger.info("Check checkbox 'Sign up for our newsletter!'- newsletter");
        webDriver.findElement(By.id("optin")).click();
        logger.info("''Check checkbox 'Receive special offers from our partners!'- optin");

        //YOUR ADDRESS
        webDriver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("Vita");
        logger.info("First name is visible - //input[@id='firstname']");
        webDriver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("Kucheruk");
        logger.info("Last name is visible - //input[@id='lastname']");
        webDriver.findElement(By.id("address1")).sendKeys("78 Nova, 01526, SuperCompany Co");
        logger.info("Input address - address1");
        webDriver.findElement(By.id("city")).sendKeys("Brovary");
        logger.info("Input city - city");
        webDriver.findElement(By.id("uniform-id_state")).click();
        logger.info("Check opening drop-down list - uniform-id_state");
      // webDriver.findElement(By.xpath("//p[@class='required id_state select form-group']/div[@id='uniform-id_state']/[@checked]/span[@text='Alabama']")).click();
        Select state = new Select(webDriver.findElement(By.id("id_state")));
        state.selectByVisibleText("Alabama");
        logger.info("Choose Alabama state - id_state (Alabama)");

        webDriver.findElement(By.id("postcode")).sendKeys("01526");
        logger.info("Input postcode - postcode");

        webDriver.findElement(By.id("id_country")).isDisplayed();
        Select country = new Select(webDriver.findElement(By.id("id_country")));
        country.selectByVisibleText("United States");
        logger.info("Check the United States country is displayed - id_country (United States)");

        webDriver.findElement(By.id("phone_mobile")).sendKeys("+38 013 31 03");
        logger.info("Input mobile phone number - phone_mobile");
        webDriver.findElement(By.id("alias")).isDisplayed();
        logger.info("Check alias box is displayed - alias");
        webDriver.findElement(By.id("submitAccount")).click();
        logger.info("Finish creation account - submitAccount");

        webDriver.close();
    }
}
