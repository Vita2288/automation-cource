package MainTests;

import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage.MainPage;
import pages.MainPage.RegistrationPage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public MainPage mainPage;
    public Logger logger;
    public String browser;
    public Utils utils = new Utils();
    public String pathToScreenShot;
    private boolean isTestPass = false;

    public MainTest(String browser){
        this.browser = browser;
    }

    @Parameterized.Parameters
    private static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
                {"chrome"},
                {"firefox"}

        });
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws IOException{
        if("chrome".equals(browser)){
            logger.info(browser + "will be started");
            File chromeFF = new File("E:\\QA_Automation/Homework/qa_Kucheruk_g1/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", ((File) chromeFF).getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + "is started");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else if ("firefox".equals(browser)) {
            logger.info(browser + "will be started");
            File fireFox = new File("E:\\QA_Automation/Homework/qa_Kucheruk_g1/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", ((File) fireFox).getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + "is started");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        File file = new File("");
        pathToScreenShot = file.getAbsolutePath() + "\\resources\\screenshot\\" +
            this.getClass().getPackage().getName() + "\\" +
            this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + ".png";



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

   @After
        public void tearDown() {
       if (!(webDriver == null)){
           if (!isTestPass){
           utils.screenShot(pathToScreenShot, webDriver);
       }
           webDriver.quit();
       }
   }

    public void setTestPass(){
        isTestPass = true;
    }

    public void checkAC(String message, boolean actualRes, boolean expectedRes){
        Assert.assertEquals(message, actualRes, expectedRes);
    }
}
