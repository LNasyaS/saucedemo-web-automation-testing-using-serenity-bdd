package pageObject;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    public static WebDriver driver;
    public static BasePage basePage;


    public InventoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.basePage = new BasePage(driver);
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

        basePage.scrollIntoView(button);

        button.click();
    }

    public void clickShoppingCart() {
        basePage.scrollIntoView(shoppingCart);

        shoppingCart.click();
    }

}