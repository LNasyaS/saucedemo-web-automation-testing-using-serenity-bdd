package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePage.BasePage;


public class CheckoutOverviewPage {

    public WebDriver driver;


    public CheckoutOverviewPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

//  locator
    @FindBy(xpath= "//span[text()='Checkout: Overview']")
    private  WebElement labelCheckout;

    @FindBy(xpath = "//div[@class='cart_list']")
    private  WebElement checkoutItem;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private  WebElement totalPrice;

    @FindBy(xpath = "//button[@id='finish']")
    private static WebElement finishButton;

//  function
    public boolean verifyCheckoutOverviewPage() {

        BasePage.scrollToElement(labelCheckout);
        BasePage.scrollToElement(checkoutItem);
        BasePage.scrollToElement(totalPrice);

        labelCheckout.isDisplayed();
        checkoutItem.isDisplayed();
        totalPrice.isDisplayed();
        return true;
    }

    public static void clickFinishButton() {
        finishButton.click();
    }



}
