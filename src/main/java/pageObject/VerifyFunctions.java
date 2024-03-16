package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class VerifyFunctions {

    public static WebDriver driver;

    public VerifyFunctions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

//  verify number of items in shopping cart
    @FindBy(xpath = "//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']")
    private static WebElement shoppingCartBadge;

    public static void verifyShoppingCartItemCount(String expectedItemCount) {
        try {
            Duration timeout = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(shoppingCartBadge));

            String actualItemCountText = shoppingCartBadge.getText();
            int expectedItemCountInt = Integer.parseInt(expectedItemCount);
            int actualItemCount = actualItemCountText.isEmpty() ? 0 : Integer.parseInt(actualItemCountText);

            assertEquals(expectedItemCountInt, actualItemCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//  verify total price

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private static WebElement itemTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private static WebElement tax;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private static WebElement totalPrice;

    private static double roundToTwoDecimal(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static double extractItemTotal() {
        String content = itemTotal.getText();
        String[] split = content.split("\\$");

        if(split.length > 1) {
            String number = split[1].trim();
            double numberDouble = Double.parseDouble(number);
            return roundToTwoDecimal(numberDouble);
        } else {
            return 0.0;
        }
    }

    public static double extractTax() {
        String content = tax.getText();
        String[] split = content.split("\\$");

        if(split.length > 1) {
            String number = split[1].trim();
            double numberDouble = Double.parseDouble(number);
            return roundToTwoDecimal(numberDouble);
        } else {
            return 0.0;
        }
    }

    public static double extractTotalPrice() {
        String content = totalPrice.getText();
        String[] split = content.split("\\$");

        if(split.length > 1) {
            String number = split[1].trim();
            double numberDouble = Double.parseDouble(number);
            return roundToTwoDecimal(numberDouble);
        } else {
            return 0.0;
        }
    }

    public static void verifyTotalPrice(double extractItemTotal, double extractTax, double extractTotalPrice) {
        double taxPercentage = 0.08;
        double expectedTax = extractItemTotal * taxPercentage;
        assertEquals(expectedTax, extractTax, 0.01);

        double expectedTotalPrice = extractItemTotal + expectedTax;
        assertEquals(expectedTotalPrice, extractTotalPrice, 0.01);
    }
}
