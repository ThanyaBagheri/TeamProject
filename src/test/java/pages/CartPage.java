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
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBtn;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartBtn;

    @FindBy(className = "inventory_item_name")
    public WebElement item;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeFromCartBtn;
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

}
