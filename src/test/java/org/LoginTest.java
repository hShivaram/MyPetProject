package org;

import objectRepository.HomePageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseClass;
import resources.UtilsClass;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class LoginTest extends BaseClass {
    UtilsClass ut = new UtilsClass();
    public WebDriver _driver;
    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    @BeforeTest
    public void startapp() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        _driver = initialiseDriver();
    }

    @Test
    public void signInToApp(){
        _driver.get(prop.getProperty("URL"));
        log.info("The application is loading");
        HomePageObject hm = new HomePageObject(_driver);
        log.info("Waiting for SignIn button");
        ut.waitforElement(_driver,hm.getSignIn_btn());
        log.debug("Verify whether Signin button is found");
        ut.click(hm.getSignIn_btn());
        log.info("Successfully clicked submit button");
        ut.waitforElement(_driver,hm.getEmail_field());
        log.info("Waiting for Email field");
        ut.sendKeys(hm.getEmail_field(), prop.getProperty("emailaddress"));
        ut.click(hm.getSubmit());
        log.info("Successfully click on submit for new application");
        ut.waitforElement(_driver,hm.getFirst_name());
        ut.sendKeys(hm.getFirst_name(), prop.getProperty("firstname"));
        ut.waitforElement(_driver,hm.getLast_name());
        ut.sendKeys(hm.getFirst_name(), prop.getProperty("lastname"));
    }

    @AfterTest
    public void teardown()
    {
        _driver.close();
    }
}
