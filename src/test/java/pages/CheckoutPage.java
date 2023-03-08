package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "shopping_cart_link")
    public WebElement cartBtn;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(xpath = "//h3")
    public WebElement checkoutInfo;

    @FindBy(id = "first-name")
    public WebElement firstNameFill;

    @FindBy(id = "last-name")
    public WebElement lastNameFill;

    @FindBy(id = "postal-code")
    public WebElement zipCodeFill;

    @FindBy(xpath = "//div[normalize-space()='Payment Information']")
    public WebElement paymentInfo;

    @FindBy(xpath = "//div[normalize-space()='Shipping Information']")
    public WebElement shippingInfo;

    @FindBy(xpath = "//div[normalize-space()='Price Total']")
    public WebElement priceTotal;
}
