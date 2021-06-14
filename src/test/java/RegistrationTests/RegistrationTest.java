package RegistrationTests;

import MainTests.MainTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class RegistrationTest extends MainTest {


    @Test
    public void testRegistrationValidByPageObjWithoutStateValue(){
        registrationPage.openRegistrationPage();
        registrationPage.checkTitle("Login - My Store");
        registrationPage.inputToSingIn();
        registrationPage.checkTitle("Login - My Store");

        var email = "vita" + UUID.randomUUID() +".kucheruk@gmail.com";
        registrationPage.inputEmailCreate(email);

        registrationPage.submitButtonCreate();
                //another way
        registrationPage.clickOnRadioButton();
        registrationPage.inputCustomerFirstName("Vita");
        registrationPage.inputCustomerLastName("Kucheruk");
        registrationPage.emailDisplayed("vita451444241.kucheruk@gmail.com");
        registrationPage.inputPassword("kkll;mkl");
        registrationPage.clickCheckboxNL();
        registrationPage.clickCheckboxRSO();
        registrationPage.inputFirstName("Vita");
        registrationPage.inputLastName("Kucheruk");
        registrationPage.inputAddress("78 Nova, 01526, SuperCompany Co");
        registrationPage.inputCity("Brovary");
        registrationPage.clickOnStateWindow();
   //     registrationPage.selectState();
        registrationPage.inputPostcode("01526");
        registrationPage.isDisplayedTextByXpath("-");
        registrationPage.selectCountry();
        registrationPage.inputMobile("+38 013 31 03");
        registrationPage.inputAlias("vita455.kucheruk@gmail.com");
        registrationPage.clickSubmitAccountButton();
        checkAC("My account", registrationPage.titleRegistratedAccount.isDisplayed(), true);

        String []  errorMassage = registrationPage.errorCount.getText().split("\n");

        String expectedErrorCount = String.format(registrationPage.errorCountMsgTemplate, errorMassage.length-1);

        Assert.assertEquals(expectedErrorCount, errorMassage[0]);
        Assert.assertEquals(registrationPage.errorState, errorMassage[1]);

       // checkAC("The text is present", registrationPage.titleRegistratedAccount.isDisplayed(),true);
    }
}

