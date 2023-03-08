package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//h3")
    public WebElement errorMsg;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutMsg;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement openMenu;

//    public void login(){
//        usernameInput.sendKeys("standard_user");
//        passwordInput.sendKeys("secret_sauce");
//        loginBtn.click();
//    }
    public void login(){
        sendKeys(usernameInput,"standard_user");
        sendKeys(passwordInput,"secret_sauce");
        click(loginBtn);
    }
}
