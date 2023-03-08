package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "react-burger-menu-btn")
    public WebElement navMenuBtn;

    @FindBy(xpath = "//nav[@class='bm-item-list']/a")
    public List<WebElement> followingBtns;

    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    public List<WebElement> filterOptions;

    @FindBy(xpath = "//ul//li")
    public List<WebElement> socialMedBtns;
    @FindBy(id = "about_sidebar_link")
    public WebElement aboutBtn;

}
