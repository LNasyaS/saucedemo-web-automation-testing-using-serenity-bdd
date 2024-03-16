package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PurchaseSteps {

    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);
    YourCartPage yourCartPage = new YourCartPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    YourInformationPage yourInformationPage = new YourInformationPage(driver);
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
    VerifyFunctions verifyFunctions = new VerifyFunctions(driver);


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
        VerifyFunctions.verifyShoppingCartItemCount(expectedItemCount);
    }

    @When("User click shopping cart")
    public void userClickShoppingCart() {
        inventoryPage.clickShoppingCart();
    }

    @Then("User is already on Your Cart page")
    public void userIsAlreadyOnYourCartPage() {
        Assert.assertTrue(yourCartPage.verifyLabelYourCart());
    }

    @When("User click remove button for item {string}")
    public void userClickRemoveButtonForItem(String item) {
        yourCartPage.clickRemoveButton(item);
    }

    @Then("User should see the shopping cart icon show the updated number of {string} items")
    public void userShouldSeeTheShoppingCartIconShowTheUpdatedNumberOfItems(String expectedItemCount) {
        verifyFunctions.verifyShoppingCartItemCount(expectedItemCount);
    }

    @When("User click Checkout button")
    public void userClickCheckoutButton() {
        yourCartPage.clickCheckoutButton();
    }

    @Then("User is already on Checkout: Your Information page")
    public void userIsAlreadyOnCheckoutYourInformationPage() {
        Assert.assertTrue(yourInformationPage.verifyYourInformationPage());
    }

    @When("User input {string} as First Name and {string} as Last Name and {string} as Zip Code and click continue")
    public void userInputAsFirstNameAndAsLastNameAndAsZipPostalCodeAndClickContinue(String firstName, String lastName, String zip) {
        yourInformationPage.inputFirstName(firstName);
        yourInformationPage.inputLastName(lastName);
        yourInformationPage.inputZip(zip);
        yourInformationPage.clickContinueButton();
    }

    @Then("User is already on Checkout: Overview page")
    public void userIsAlreadyOnCheckoutOverviewPage() {
        Assert.assertTrue(checkoutOverviewPage.verifyCheckoutOverviewPage());
    }


    @When("User can see the verified total price")
    public void userCanSeeTheVerifiedTotalPrice() {
        double extractItemTotal = VerifyFunctions.extractItemTotal();
        double extractTax = VerifyFunctions.extractTax();
        double extractTotalPrice = VerifyFunctions.extractTotalPrice();
        verifyFunctions.verifyTotalPrice(extractItemTotal, extractTax, extractTotalPrice);
    }

    @And("User click Finish button")
    public void userClickFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }


    @Then("User is already on Checkout:Complete! page")
    public void userIsAlreadyOnCheckoutCompletePage() {
        Assert.assertTrue(checkoutCompletePage.verifyCheckoutCompletePage());
    }
}
