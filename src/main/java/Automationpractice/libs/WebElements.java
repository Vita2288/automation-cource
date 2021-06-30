package Automationpractice.libs;

import org.apache.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElements {

    WebDriver webDriver;
    Logger logger;

    public WebElements (WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method inputs test to WebElement
     * @param element
     * @param text
     */
    public void inputText(WebElement element, String text) {
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");

        } catch (Exception e){
            logger.error("Can`t work with element" + text);
        }
    }

    public void clickOnElement(WebElement element){
       try {
           element.click();
           logger.info("Element was clicked " + element);
       }catch (Exception e){
           logger.error("Can`t click on element" + element);
           Assert.fail("Can`t click on element" + element);
       }
    }

    /**
     * Method check select text in dropdown
     * @param dropDown
     * @param text
     */
    public void selectTextInDropDownByText(WebElement dropDown, String text){
        try{
            Select optionFromDropDown = new Select(dropDown);
            optionFromDropDown.selectByVisibleText(text);
    //      optionFromDropDown.deselectByValue(text);
            logger.info("was selected DropDown by text");
        }catch (Exception e){
            logger.error("Can`t work with DropDown");
            Assert.fail("Can`t work with DropDown");
        }
    }

    public boolean isElementPresent(String xPathLocator) {
        try {
            return webDriver.findElement(By.xpath(xPathLocator)).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String xpath, String text) {
        try {
            String textInElement = webDriver.findElement(By.xpath(xpath)).getText();
            Assert.assertThat("", textInElement, CoreMatchers.is(text));
        } catch (Exception e){
            logger.error("Can`t check text in element");
            Assert.fail("Can`t check text in element");
        }
    }


}
