package saucedemo.pageObject;

import saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

//    public static WebDriver driver;
//
//    public LoginPage(WebDriver driver){
//        PageFactory.initElements(driver, this);
//        webDriver = driver;
//    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//  locator
    @FindBy(xpath = "//input[@id='user-name']")
    private  WebElement fieldUserName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginLogo;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;



    //  function
    public void inputFieldUserName(String userName){
        fieldUserName.sendKeys(userName);
    }

    public void inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }


    public boolean verifyLoginPage(){
        boolean a = loginLogo.isDisplayed();
        boolean b = fieldUserName.isDisplayed();
        boolean c = fieldUserName.isDisplayed();
        boolean d = loginButton.isDisplayed();
        return a && b && c && d;
    }

    public void clickLogin(){
        scrollIntoView(loginButton);
        waitForElementClickable(loginButton);
        loginButton.click();
    }
}
