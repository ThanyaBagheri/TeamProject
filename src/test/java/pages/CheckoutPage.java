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
}
