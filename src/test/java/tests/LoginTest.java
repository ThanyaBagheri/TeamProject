package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage page;

    @BeforeMethod
    public void setUp() {

        page = new LoginPage(driver);
    }

    @Test(testName = "US302", description = "locked out user attempt")
    public void test302() {
        page.sendKeys(page.usernameInput, "locked_out_user");
        page.sendKeys(page.passwordInput, "secret_sauce");
        page.click(page.loginBtn);

        String errorTxt = "Epic sadface: Sorry, this user has been locked out.";
        page.assertEquals(page.errorMsg.getText(), errorTxt);

    }
}