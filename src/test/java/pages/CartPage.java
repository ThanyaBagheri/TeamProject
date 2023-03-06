package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBtn;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartBtn;

    @FindBy(className = "inventory_item_name")
    public WebElement item;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeFromCartBtn;

}
