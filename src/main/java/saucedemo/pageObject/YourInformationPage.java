package saucedemo.pageObject;

import saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourInformationPage extends BasePage {

//    public WebDriver driver;
//
//    public YourInformationPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//    }

    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

//  locator
    @FindBy(xpath = "//span[@class='title']")
    private WebElement labelYourInformation;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement fieldFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement fieldLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement fieldZip;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

//  function
    public boolean verifyYourInformationPage() {
        labelYourInformation.isDisplayed();
        fieldFirstName.isDisplayed();
        fieldLastName.isDisplayed();
        fieldZip.isDisplayed();
        return true;
    }

    public void inputFirstName(String firstName){
        fieldFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        fieldLastName.sendKeys(lastName);
    }

    public void inputZip(String zip){
        fieldZip.sendKeys(zip);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
