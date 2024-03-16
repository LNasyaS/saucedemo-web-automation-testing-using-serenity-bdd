package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.InventoryPage;
import pageObject.LoginPage;


public class LoginSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);


    @Given("user open the web page")
    public void verifyLoginPage() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("User input {string} as userName and {string} as password and click login")
    public void inputCredential(String userName, String password)  {
        loginPage.inputFieldUserName(userName);
        loginPage.inputFieldPassword(password);
        loginPage.clickLogin();
    }

    @Then("User see error {string} on login page")
    public void verifyErrorMessage(String errorText) {
        Assert.assertEquals(errorText, loginPage.getErrorMessage());
    }

    @Then("User is already on the landing page")
    public void userAlreadyOnDashboardPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.verifyLabelProduct());
    }
}
