package AutomationPracticeTests.RegistrationTests;

import AutomationPracticeTests.MainTest.MainTestNG;
import org.testng.annotations.Test;

public class CustomerServiceTestNG extends MainTestNG {

    @Test
    public void testMainPageElements(){
        customerServicePage.checkTitle("My Store");
    }


    @Test
    public void testContactUsPage(){
        customerServicePage.clickOnContactUsButton();
        customerServicePage.openCustomerServicePage();
        customerServicePage.checkTitle("Contact us - My Store");

        customerServicePage.selectSubjectHeading("Customer service");

        customerServicePage.inputEmailAddress("vita.kucheruk@gmail.com");
        customerServicePage.inputOrderReference("Hello, friends");

        customerServicePage.isDisplayedTextByXpath("No file selected");


        customerServicePage.submitButtonSend();

        customerServicePage.isDisplayedTextByXpath("Your message has been successfully sent to our team.");


    }
}

