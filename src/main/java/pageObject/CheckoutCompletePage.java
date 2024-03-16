package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    public static WebDriver webDriver;

    public CheckoutCompletePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver = driver;
    }

//  locator
    @FindBy(xpath = "//span[@class='title']")
    private static WebElement labelComplete;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private static WebElement completeHeader;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private static WebElement backHomeButton;

//  function

    public static boolean verifyCheckoutCompletePage() {
        labelComplete.isDisplayed();
        completeHeader.isDisplayed();
        backHomeButton.isDisplayed();
        return true;
    }

}
