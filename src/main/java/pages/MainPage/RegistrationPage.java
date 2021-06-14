package pages.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "customer_lastname")
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

    @FindBy(xpath = "//div[@id='center_column']/div[@class='alert alert-danger']")
    public WebElement errorCount;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[1]")
    public WebElement error1;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[2]")
    public WebElement error2;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[3]")
    public WebElement error3;

    public String errorCountMsgTemplate = "There is %s error";

    public String errorState = "This country requires you to choose a State.";

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
        webElements.clickOnElement(loginInput);
    }

    /**
     * Method click to SignIn page
     *
     * @param email
     */

    public void inputEmailCreate(String email) {
        webElements.inputText(emailInput, email);
    }

    /**
     * Method submit button
     */
    public void submitButtonCreate() {
        webElements.clickOnElement(submitButtonCreate);
    }

    public void clickOnRadioButton() {
        webElements.clickOnElement(radioButton);
    }

    public void inputCustomerFirstName(String firstName) {
        webElements.inputText(customerFNinput, firstName);
    }

    public void inputCustomerLastName(String lastName) {
        webElements.inputText(customerLNinput, lastName);
    }

    public void emailDisplayed(String email) {
        webElements.isElementPresent(email);
    }

    public void inputPassword(String password) {
        webElements.inputText(passwordInput, password);
    }

    public void clickCheckboxNL() {
        webElements.clickOnElement(checkboxNewsLetter);
    }

    public void clickCheckboxRSO() {
        webElements.clickOnElement(checkboxReceiveSpecialOffers);
    }

    public void inputFirstName(String firstname) {
        webElements.isElementPresent(firstname);
    }

    public void inputLastName(String lastname) {
        webElements.isElementPresent(lastname);
    }

    public void inputAddress(String address) {
        webElements.inputText(addressInput, address);
    }

    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    public void clickOnStateWindow (){
        webElements.clickOnElement(stateWindowOpen);
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

    public void inputPostcode(String postcode){
        webElements.inputText(postcodeInput,postcode);
    }

    public void isDisplayedTextByXpath(String text){
        webElements.isElementPresent(text);
    }

    public void selectCountry() {
        try {
            Select country = new Select(webDriver.findElement(By.id("iid_country")));
            country.selectByVisibleText("United States");
            logger.info("Find select country United State");
        } catch (Exception e) {
            logger.error("Can`t find select country United State");
        }
    }

    public void inputMobile(String mobile){
        webElements.inputText(mobilePhoneInput, mobile);
    }

    public void inputAlias (String alias){
        webElements.inputText(aliasBox, alias);
    }

    public void clickSubmitAccountButton(){
        webElements.clickOnElement(submitAccount);
    }





}
