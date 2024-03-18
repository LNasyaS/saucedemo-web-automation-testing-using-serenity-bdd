package saucedemo.pageObject;

import saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class InventoryPage extends BasePage {

//    public WebDriver driver;
//
//    public InventoryPage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver,this);;
//    }

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

//  locator
    @FindBy(className= "title")
    private WebElement labelProduct;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortProduct;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;



    //  function
    public boolean verifyLabelProduct() {
        labelProduct.isDisplayed();
        inventoryList.isDisplayed();
        return true;
    }

    public void selectSortProduct(String text){
        Select select = new Select(sortProduct);
        select.selectByVisibleText(text);
    }


    public void clickButtonAddToCart(String item) {
        String buttonXpath = "//div[text()='"+ item +"']/ancestor::div[@class='inventory_item_description']//button[text()='Add to cart']";
        WebElement button = driver.findElement(By.xpath(buttonXpath));

        scrollIntoView(button);
        button.click();
    }

    public void clickShoppingCart() {
        scrollIntoView(shoppingCart);
        shoppingCart.click();
    }

    public void verifyShoppingCartItemCount(String expectedItemCount) {
        waitForElementVisible(shoppingCartBadge);

        String actualItemCountText = shoppingCartBadge.getText();
        int expectedItemCountInt = Integer.parseInt(expectedItemCount);
        int actualItemCount = actualItemCountText.isEmpty() ? 0 : Integer.parseInt(actualItemCountText);

        assertEquals(expectedItemCountInt, actualItemCount);

    }

}
