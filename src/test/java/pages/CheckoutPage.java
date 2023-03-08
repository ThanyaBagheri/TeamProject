package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(id = "finish")
    public WebElement finishBtn;

    @FindBy(className = "complete-header")
    public WebElement confirmationMsg;

    @FindBy(id = "cancel")
    public WebElement cancelBtn;

    @FindBy(className = "title")
    public WebElement productTxt;
    @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;
    @FindBy(xpath = "//span[text()='Products']")
    public WebElement verifyProducts;

    public void gotoCheckout(LoginPage loginPage){
        loginPage.login();
        click(cartBtn);
        click(checkoutBtn);
    }

    public void enterCheckoutInfo(){
        sendKeys(firstNameFill,"JohnDoe");
        sendKeys(lastNameFill,"Doe");
        sendKeys(zipCodeFill,"22192");

        click(continueBtn);
    }
    @FindBy(xpath = "//*[text()='Add to cart']")
    public List<WebElement> inventoryItemsBtns;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCartBtn;
    @FindBy(id = "first-name")
    public WebElement firstNameField;
    @FindBy(id = "last-name")
    public WebElement lastNameField;
    @FindBy(id = "postal-code")
    public WebElement postalCodeField;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement itemTotal;
    @FindBy(xpath = "//div[@class='summary_tax_label']")
    public WebElement tax;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement total;



    public void addToCartAllItems(){
        for (WebElement each : inventoryItemsBtns){
            click(each);
        }
    }
    public void fillCheckoutForm(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String postalCode = faker.address().zipCode();

        click(checkoutBtn);

        sendKeys(firstNameField, firstName);
        sendKeys(lastNameField, lastName);
        sendKeys(postalCodeField, postalCode);

        click(continueBtn);
    }
    public double getSumFromString(WebElement sumStr){
        String str = sumStr.getText();
        System.out.println(str);
        String[] split = str.split(" ");
        String strNum = split[split.length-1].substring(1);
        System.out.println(strNum);
        double sum = Double.parseDouble(strNum);
        return sum;
    }

}
