package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class BaseClass {
    public WebDriver _driver;
    public Properties prop;
    public WebDriver initialiseDriver() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        String path = System.getProperty("user.dir")+"/src/main/java/resources/data.properties";
        prop = new Properties();
        FileInputStream file = new FileInputStream(path);
        prop.load(file);
        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            _driver = new ChromeDriver();
        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            _driver = new FirefoxDriver();
        }
        else{
            DriverManagerType safari = DriverManagerType.SAFARI;
            WebDriverManager.getInstance(safari).setup();
            Class<?> safariClass =  Class.forName(safari.browserClass());
            _driver = (WebDriver) safariClass.getDeclaredConstructor().newInstance();
        }

        return _driver;

    }



    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;

    }
}
