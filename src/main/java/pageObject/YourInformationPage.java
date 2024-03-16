package pageObject;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {

    public static WebDriver driver;


    public YourInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

//  locator
    @FindBy(xpath = "//span[@class='title']")
    private WebElement labelYourInformation;

    @FindBy(xpath = "//input[@id='first-name']")
    private static WebElement fieldFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private static WebElement fieldLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private static WebElement fieldZip;

    @FindBy(xpath = "//input[@id='continue']")
    private static WebElement continueButton;


    //  function
    public boolean verifyYourInformationPage() {
        labelYourInformation.isDisplayed();
        fieldFirstName.isDisplayed();
        fieldLastName.isDisplayed();
        fieldZip.isDisplayed();
        return true;
    }

    public static void inputFirstName(String firstName){
        fieldFirstName.sendKeys(firstName);
    }

    public static void inputLastName(String lastName){
        fieldLastName.sendKeys(lastName);
    }

    public static void inputZip(String zip){
        fieldZip.sendKeys(zip);
    }

    public static void clickContinueButton() {
        continueButton.click();
    }

}
