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
    private WebElement emailDisplayed;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "newsletter")
    private WebElement checkboxNewsLetter;

    @FindBy(id = "optin")
    private WebElement checkboxReceiveSpecialOffers;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement checkFN;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement checkLN;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "uniform-id_state")
    private WebElement stateWindowOpen;

    @FindBy(id = "id_state")
    private WebElement selectStateByIndex;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "id_country")
    private WebElement idCountry;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasBox;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    private WebElement titleRegistratedAccount;

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
     * Method click  to SignIn page
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
}
