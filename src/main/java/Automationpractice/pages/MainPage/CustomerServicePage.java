package Automationpractice.pages.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerServicePage extends MainPage {

    public static final String ERROR_STATE = "This country requires you to choose a State.";
    public static final String ERROR_PASSWORD_MISSING = "passwd is required.";

    public static String errorCountMsgTemplate = "There is %s error";


    @FindBy(xpath = "//a[@title='Contact Us']")
    public WebElement contactUsButton;

    @FindBy(xpath = "//select[@id='id_contact']")
    public  WebElement subjectHeading;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@id='id_order']")
    public WebElement orderReference;

    @FindBy (xpath = "//textarea[@id='message']")
    public WebElement message;

    @FindBy(id = "SubmitCreate")
    public WebElement sendButton;

    //Constructor

    public CustomerServicePage(WebDriver webDriver) {
        super(webDriver);
    }

    //METODS to work with locators

    public void openCustomerServicePage() {
        openUrl("http://automationpractice.com/index.php?controller=contact");
    }

    /**
     * Method click on Contact us button
     */
    public void clickOnContactUsButton() {
        webElements.clickOnElement(contactUsButton);
    }

    /**
     * Method select Subject Heading
     */
    public void selectSubjectHeading(String text) {
        webElements.selectTextInDropDownByText(subjectHeading, text);
    }

    /**
     * Method input email address
     * @param text
     */
    public void inputEmailAddress(String text){
        webElements.inputText(emailAddress, text);
    }

    /**
     * Method sent button
     */
    public void submitButtonSend() {
        webElements.clickOnElement(sendButton);
    }

    public void inputOrderReference(String firstName) {
        webElements.inputText(orderReference, firstName);
    }




    public void isDisplayedTextByXpath(String text){
        webElements.isElementPresent(text);
    }




}
