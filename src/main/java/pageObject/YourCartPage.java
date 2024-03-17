package pageObject;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YourCartPage {

    public static WebDriver driver;
    public static BasePage basePage;


    public YourCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.basePage = new BasePage(driver);

    }

//  locator
    @FindBy(xpath = "//span[text()='Your Cart']")
    private static WebElement labelYourCart;

    @FindBy(xpath = "//div[@class='cart_list']")
    private static WebElement cartList;

    @FindBy(xpath = "//button[@id='checkout']")
    private static WebElement checkoutButton;


//  function
    public static boolean verifyLabelYourCart() {
        labelYourCart.isDisplayed();
        cartList.isDisplayed();
        return true;
    }

    public static void clickRemoveButton(String item) {
        String button = "//div[@class='cart_list']//div[text()='"+ item +"']/ancestor::div[@class='cart_item_label']//button[text()='Remove']";
        driver.findElement(By.xpath(button)).click();
    }

    public static void clickCheckoutButton() {
        basePage.scrollIntoView(checkoutButton);

        checkoutButton.click();
    }

}
