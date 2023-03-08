package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    @FindBy(id = "continue")
    public WebElement continueBtn;
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
