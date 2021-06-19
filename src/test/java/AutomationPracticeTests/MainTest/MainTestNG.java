package AutomationPracticeTests.MainTest;

import Automationpractice.pages.MainPage.RegistrationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainTestNG {

    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public Logger logger;


    public MainTestNG() {
    }

    @Parameters("browser")

    @BeforeClass
    public void setUp() {
        File chromeFF = new File("E:\\QA_Automation/Homework/qa_Kucheruk_g1/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ((File) chromeFF).getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        registrationPage = new RegistrationPage(webDriver);
        logger = Logger.getLogger(getClass());

        try {
            //MAIN PAGE
            webDriver.get("http://automationpractice.com");
            logger.info("Open link - http://automationpractice.com");
        } catch (Exception e) {
            logger.error("Can`t open browser");
            Assert.fail("Can`t open browser");
        }
    }

    @AfterClass
    public void tearDown() {
        if (!(webDriver == null)) {
            webDriver.quit();
        }
    }

}

//        public void checkAC(String message, boolean actualRes, boolean expectedRes){
//            Assert.assertEquals(message, actualRes, expectedRes);
//        }
