package saucedemo.pageObject;


import saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class YourCartPage extends BasePage {

//    public WebDriver driver;
//
//    public YourCartPage(WebDriver driver){
//        PageFactory.initElements(driver,this);
//        this.driver = driver;
//    }

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

//  locator
    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement labelYourCart;

    @FindBy(xpath = "//div[@class='cart_list']")
    private WebElement cartList;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;


    //  function
    public boolean verifyLabelYourCart() {
        labelYourCart.isDisplayed();
        cartList.isDisplayed();
        return true;
    }

    public void clickRemoveButton(String item) {
        String button = "//div[@class='cart_list']//div[text()='"+ item +"']/ancestor::div[@class='cart_item_label']//button[text()='Remove']";
        driver.findElement(By.xpath(button)).click();
    }

    public void clickCheckoutButton() {
        scrollIntoView(checkoutButton);
        checkoutButton.click();
    }

}
