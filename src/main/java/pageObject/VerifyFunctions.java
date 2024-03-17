package pageObject;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.junit.Assert.assertEquals;

public class VerifyFunctions {

    public static WebDriver driver;

    public static BasePage basePage;

    public VerifyFunctions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.basePage = new BasePage(driver);

    }

    /*verify number of items in shopping cart*/
    @FindBy(xpath = "//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']")
    private static WebElement shoppingCartBadge;


    public void verifyShoppingCartItemCount(String expectedItemCount) {
        try {
            basePage.waitForElementVisible(shoppingCartBadge);

            String actualItemCountText = shoppingCartBadge.getText();
            int expectedItemCountInt = Integer.parseInt(expectedItemCount);
            int actualItemCount = actualItemCountText.isEmpty() ? 0 : Integer.parseInt(actualItemCountText);

            assertEquals(expectedItemCountInt, actualItemCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*verify total price*/
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private static WebElement itemTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private static WebElement tax;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private static WebElement totalPrice;

//  functions
    private static double roundToTwoDecimal(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double trim(String content) {
        String[] split = content.split("\\$");

        if(split.length > 1) {
            String number = split[1].trim();
            double numberDouble = Double.parseDouble(number);
            return numberDouble;
        } else {
            return 0.0;
        }
    }

//  extract from web
    public static double extractItemTotal() {
        String content = itemTotal.getText();
        return trim(content);
    }

    public static double extractTax() {
        String content = tax.getText();
        return trim(content);
    }

    public static double extractTotalPrice() {
        String content = totalPrice.getText();
        return trim(content);
    }

    public static void verifyTotalPrice(double extractItemTotal, double extractTax, double extractTotalPrice) {
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
