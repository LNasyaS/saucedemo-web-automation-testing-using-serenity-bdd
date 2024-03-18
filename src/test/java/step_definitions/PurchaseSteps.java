package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import saucedemo.pageObject.*;

public class PurchaseSteps {

    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);
    YourCartPage yourCartPage = new YourCartPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    YourInformationPage yourInformationPage = new YourInformationPage(driver);
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);


    @When("User sort product by {string}")
    public void sortProduct(String text) {
        inventoryPage.selectSortProduct(text);
    }

    @And("User click add to cart item {string}")
    public void userClickAddToCartItem(String item) {
        inventoryPage.clickButtonAddToCart(item);
    }

    @Then("User should see the shopping cart icon show the number of {string} items")
    public void userShouldSeeTheShoppingCartIconShowTheNumberOfItems(String expectedItemCount) {
        inventoryPage.verifyShoppingCartItemCount(expectedItemCount);
    }

    @When("User click shopping cart")
    public void userClickShoppingCart() {
        inventoryPage.clickShoppingCart();
    }

    @Then("User is already on your cart page")
    public void userIsAlreadyOnYourCartPage() {
        Assert.assertTrue(yourCartPage.verifyLabelYourCart());
    }

    @When("User click remove button for item {string}")
    public void userClickRemoveButtonForItem(String item) {
        yourCartPage.clickRemoveButton(item);
    }


    @When("User click checkout button")
    public void userClickCheckoutButton() {
        yourCartPage.clickCheckoutButton();
    }

    @Then("User is already on checkout your information page")
    public void userIsAlreadyOnCheckoutYourInformationPage() {
        Assert.assertTrue(yourInformationPage.verifyYourInformationPage());
    }

    @When("User input {string} as firstName and {string} as lastName and {string} as zip and click continue")
    public void userInputAsFirstNameAndAsLastNameAndAsZipPostalCodeAndClickContinue(String firstName, String lastName, String zip) {
        yourInformationPage.inputFirstName(firstName);
        yourInformationPage.inputLastName(lastName);
        yourInformationPage.inputZip(zip);
        yourInformationPage.clickContinueButton();
    }

    @Then("User is already on checkout overview page")
    public void userIsAlreadyOnCheckoutOverviewPage() {
        Assert.assertTrue(checkoutOverviewPage.verifyCheckoutOverviewPage());
    }


    @And("User can see the verified total price")
    public void userCanSeeTheVerifiedTotalPrice() {
        double extractItemTotal = checkoutOverviewPage.extractItemTotal();
        double extractTax = checkoutOverviewPage.extractTax();
        double extractTotalPrice = checkoutOverviewPage.extractTotalPrice();
        checkoutOverviewPage.verifyTotalPrice(extractItemTotal, extractTax, extractTotalPrice);
    }

    @When("User click finish button")
    public void userClickFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }

    @Then("User is already on checkout complete page")
    public void userIsAlreadyOnCheckoutCompletePage() {
        Assert.assertTrue(checkoutCompletePage.verifyCheckoutCompletePage());
    }
}
