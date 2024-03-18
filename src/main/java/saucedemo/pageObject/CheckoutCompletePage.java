package saucedemo.pageObject;

import saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

//    public WebDriver driver;
//
//    public CheckoutCompletePage(WebDriver driver){
//        PageFactory.initElements(driver,this);
//        webDriver = driver;
//    }

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

//  locator
    @FindBy(xpath = "//span[@class='title']")
    private WebElement labelComplete;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeButton;



//  function

    public boolean verifyCheckoutCompletePage() {
        labelComplete.isDisplayed();
        completeHeader.isDisplayed();
        backHomeButton.isDisplayed();
        return true;
    }

}
