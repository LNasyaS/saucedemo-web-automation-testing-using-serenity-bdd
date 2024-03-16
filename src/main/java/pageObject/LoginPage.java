package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver webDriver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
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

    public void clickLogin(){
        loginButton.click();
    }

    public boolean verifyLoginPage(){
        boolean a = loginLogo.isDisplayed();
        boolean b = fieldUserName.isDisplayed();
        boolean c = fieldUserName.isDisplayed();
        boolean d = loginButton.isDisplayed();
        return a && b && c && d;
    }

}
