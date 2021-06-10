package pages.MainPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class RegistrationPage extends MainPage {

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(xpath = "//form[@id='account-creation_form']/div[@class='account_creation']/div[@class='clearfix']/div[2]")
    public WebElement radioButton;

    @FindBy(id = "customer_firstname")
    public WebElement customerFNinput;

    @FindBy(id = "customer__lastname")
    public WebElement customerLNinput;

    @FindBy(id = "email")
    public WebElement emailDisplayed;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "newsletter")
    public WebElement checkboxNewsLetter;

    @FindBy(id = "optin")
    public WebElement checkboxReceiveSpecialOffers;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement checkFN;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement checkLN;

    @FindBy(id = "address1")
    public WebElement addressInput;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "uniform-id_state")
    public WebElement stateWindowOpen;

    @FindBy(id = "id_state")
    public WebElement selectStateByIndex;

    @FindBy(id = "postcode")
    public WebElement postcodeInput;

    @FindBy(id = "id_country")
    public WebElement idCountry;

    @FindBy(id = "phone_mobile")
    public WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    public WebElement aliasBox;

    @FindBy(id = "submitAccount")
    public WebElement submitAccount;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegistratedAccount;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegistrationPage() {
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    /**
     * Method click  to SignIn page
     */

    public void inputToSingIn() {
        try {
            loginInput.click();
            logger.info("Click to SingIn");
        } catch (Exception e) {
            logger.error("Can`t click to SignIn");
            Assert.fail("Can`t click to SignIn");

        }
    }

    /**
     * Method click to SignIn page
     *
     * @param email
     */

    public void inputEmailCreate(String email) {
        try {
            emailInput.sendKeys(email);
            logger.info("Input email" + email);

        } catch (Exception e) {
            logger.error("Can`t input email" + email);
            Assert.fail("Can`t input email" + email);
        }
    }

    /**
     * Method submit button

     */
    public void submitButtonCreate (){
       try {
           submitButtonCreate.click();
           logger.info("Click submit button");
       } catch (Exception e){
           logger.error("Can`t submit button");
           Assert.fail("Can`t submit button");
       }
    }

    public void selectState(){
        try {
            Select state = new Select(webDriver.findElement(By.id("id_state")));
            state.selectByIndex(32);
            logger.info("Find select by 32");
        } catch (Exception e) {
            logger.error("Can`t find select city by 32");
        }
    }

    public void selectCountry(){
        try {
            Select country = new Select(webDriver.findElement(By.id("iid_country")));
            country.selectByVisibleText("United States");
            logger.info("Find select country United State");
        } catch (Exception e) {
            logger.error("Can`t find select country United State");
        }
    }

}
