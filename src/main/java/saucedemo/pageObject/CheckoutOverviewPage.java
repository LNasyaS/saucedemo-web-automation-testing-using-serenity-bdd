package saucedemo.pageObject;

import saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class CheckoutOverviewPage extends BasePage {

//    public WebDriver driver;
//
//    public CheckoutOverviewPage(WebDriver driver){
//        PageFactory.initElements(driver,this);
//        this.driver = driver;
//    }

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

//  locator
    @FindBy(xpath= "//span[text()='Checkout: Overview']")
    private  WebElement labelCheckout;

    @FindBy(xpath = "//div[@class='cart_list']")
    private  WebElement checkoutItem;

    @FindBy(css = ".summary_total_label")
    private WebElement totalPrice;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement tax;


    //  function
    public boolean verifyCheckoutOverviewPage() {
        labelCheckout.isDisplayed();
        checkoutItem.isDisplayed();
        totalPrice.isDisplayed();
        return true;
    }

    public void clickFinishButton() {
        finishButton.click();
    }


    /*verify total price*/
    public double extractItemTotal() {
        String content = itemTotal.getText();
        return trim(content);
    }

    public double extractTax() {
        String content = tax.getText();
        return trim(content);
    }

    public double extractTotalPrice() {
        String content = totalPrice.getText();
        return trim(content);
    }

    public void verifyTotalPrice(double extractItemTotal, double extractTax, double extractTotalPrice) {
        double taxPercentage = 0.08;
        double expectedTax = extractItemTotal * taxPercentage;
        double roundExpectedTax = roundToTwoDecimal(expectedTax);
        assertEquals(roundExpectedTax, extractTax, 0.01);

        double expectedTotalPrice = extractItemTotal + expectedTax;
        double roundedExpectedTotalPrice = roundToTwoDecimal(expectedTotalPrice);
        assertEquals(roundedExpectedTotalPrice, extractTotalPrice, 0.01);

        System.out.println("Item total = $" + extractItemTotal);
        System.out.println("Tax = $" + extractTax);
        System.out.println("Expected Tax = $" + roundExpectedTax);
        System.out.println("Total Price = $" + extractTotalPrice);
        System.out.println("Expected Total Price = $" + roundedExpectedTotalPrice);
    }



}
