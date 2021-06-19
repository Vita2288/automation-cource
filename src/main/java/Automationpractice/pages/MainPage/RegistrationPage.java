package Automationpractice.pages.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage {

    public static final String ERROR_STATE = "This country requires you to choose a State.";
    public static final String ERROR_PASSWORD_MISSING = "passwd is required.";

    public static String errorCountMsgTemplate = "There is %s error";


    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(xpath = "//div[@id='uniform-id_gender2']")
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
    public WebElement errorMassage;

    //Constructor

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }


    //METODS to work with locators

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

    public void selectState(String text){
        webElements.selectTextInDropDownByText(selectStateByIndex, text);
    }

    public void inputPostcode(String postcode){
        webElements.inputText(postcodeInput,postcode);
    }

    public void isDisplayedTextByXpath(String text){
        webElements.isElementPresent(text);
    }

    public void selectCountry(String text) {
        webElements.selectTextInDropDownByText(idCountry, text);
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

    public String[] getErrorBlock() {
/*        if (errorMassage == null) {
            return null;
        } else {
            return errorMassage.getText().split("\n");
        }*/
        return (errorMassage == null)
                ? null
                : errorMassage.getText().split("\n");
    }

    public String getErrorCountString() {
        String[] errorMassageArray = getErrorBlock();
        if (errorMassageArray == null) {
            logger.warn("Error block is null!");
            return null;
        } else {
            return String.format(errorCountMsgTemplate, errorMassageArray.length - 1);
        }
    }

    public boolean isContainError(String error) {
        boolean isContains = false;

        String[] errorMassageArray = getErrorBlock();
        if (errorMassageArray == null) {
            logger.warn("Error block is null!");
            return false;
        } else {
            for (int i = 1; i < errorMassageArray.length; i++) {
                if (errorMassageArray[i].equals(error)) {
                    isContains = true;
                    break;
                }
            }
        }
        return isContains;
    }

  /*  public void checkErrorMassageValue(String errorMsg) {
        String[] errorMassageArray = getErrorBlock();

        if (errorMassageArray == null) {
            logger.warn("Error block is null!");
        } else {
            String expectedErrorCountString = String.format(errorCountMsgTemplate, errorMassageArray.length-1);
            Assert.assertEquals(expectedErrorCountString, errorMassageArray[0]);


            boolean isContains = false;
            for(int i = 1; i < errorMassageArray.length; i++) {
                if (errorMassageArray[i].equals(errorMsg)) {
                    isContains = true;
                    break;
                }
            }

            Assert.assertTrue(isContains);
        }
    }*/


}
