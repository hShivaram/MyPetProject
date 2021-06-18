package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    WebDriver _driver;
    public HomePageObject(WebDriver driver){
        this._driver=driver;
        PageFactory.initElements(_driver,this);
    }

    @FindBy(xpath = "//div/a[contains(text(),\"Sign in\")]")
    WebElement signIn_btn;

    @FindBy(id="email_create")
    WebElement email_field;

    @FindBy(id="SubmitCreate")
    WebElement submit;

    @FindBy(id="id_gender1")
    WebElement gender_male;

    @FindBy(id="id_gender2")
    WebElement gender_female;

    @FindBy(name = "customer_firstname")
    WebElement first_name;

    @FindBy(name="customer_lastname")
    WebElement last_name;

    @FindBy(name="passwd")
    WebElement password;

    @FindBy(name="days")
    WebElement day;

    @FindBy(name="months")
    WebElement month;

    @FindBy(name="years")
    WebElement year;

    @FindBy(xpath="//input[@id='firstname']")
    WebElement add_firstname;

    public WebElement getSignIn_btn(){
        return signIn_btn;
    }

    public WebElement getEmail_field(){
        return email_field;
    }

    public WebElement getSubmit(){
        return submit;
    }

    public WebElement getGender_male(String gen){
        if(gen.equalsIgnoreCase("male")){
            return gender_male;
        }
        else{
            return gender_female;
        }

    }

    public WebElement getDay(){
        return day;
    }

    public WebElement getMonth(){
        return month;
    }

    public WebElement getYear(){
        return year;
    }

    public WebElement getFirst_name(){
        return first_name;
    }

    public WebElement getLast_name(){
        return last_name;
    }

    public WebElement getPassword(){
        return password;
    }

    public WebElement getAdd_firstname(){
        return add_firstname;
    }


}
