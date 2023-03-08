package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest{
    CheckoutPage page;
    LoginPage loginPage;
    CartPage cartPage;
    @BeforeMethod
    public void setUp() {
        page = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(testName = "US 312 - Checkout Overview Info", description = "When user enters checkout information, verify headers: Payment information, Shipping information and Price Total are displayed")
    public void test312(){
        loginPage.login();
        cartPage.cartBtn.click();
        page.checkoutBtn.click();

        page.firstNameFill.sendKeys("JohnDoe");
        page.lastNameFill.sendKeys("Doe");
        page.zipCodeFill.sendKeys("22192");

        page.continueBtn.click();

        Assert.assertTrue(page.paymentInfo.isDisplayed());
        Assert.assertTrue(page.shippingInfo.isDisplayed());
        Assert.assertTrue(page.paymentInfo.isDisplayed());
    }
}
