package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class UtilsClass {

    public WebDriverWait wait;
    public Actions actions;

    public void sendKeys(WebElement element, String value) {
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, element.toString()));
        }
    }

    public void clearField(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }

    public void click(WebElement element) {
       // waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", element));
        }
    }

    public void selectdropDown(WebDriver _driver,WebElement elem,String val){
        Select drp = new Select(elem);

        try {
            drp.selectByValue(val);
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not present: [%s]", elem));
        }
    }

    public void waitforElement(WebDriver _driver,WebElement element){
        wait = new WebDriverWait(_driver,15);
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            throw new TestException(String.format("The following element is not present: [%s]", element));
        }
    }

}
