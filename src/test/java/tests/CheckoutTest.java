package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

import java.util.List;

public class CheckoutTest extends BaseTest{
    CheckoutPage page;
    LoginPage loginPage;
    CartPage cartPage;
    @BeforeMethod
    public void setUp() {
        page = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }
    @Test(testName = "US311", description = "Checkout: Your information Error Message")
    public void test311() {
        loginPage.login();
        page.click(page.cartBtn);
        page.click(page.checkoutBtn);
        List<WebElement> checkoutInfo = driver.findElements(By.className("checkout_info"));
        page.click(page.continueBtn);
        if(checkoutInfo.size()<2){
            String errorTxt = "Error: First Name is required";
            Assert.assertEquals(page.getText(page.checkoutInfo), errorTxt);
        }

    }

    @Test(testName = "US 312 - Checkout Overview Info", description = "When user enters checkout information, verify headers: Payment information, Shipping information and Price Total are displayed")
    public void test312(){
        page.gotoCheckout(loginPage);
        page.enterCheckoutInfo();

        Assert.assertTrue(page.paymentInfo.isDisplayed());
        Assert.assertTrue(page.shippingInfo.isDisplayed());
        Assert.assertTrue(page.priceTotal.isDisplayed());
    }

    @Test(testName = "US 315 - Checkout:Complete - Confirmation", description = "When user clicks finish, the user should see a confirmation message, “Thank you for your order!”")
    public void test315() {
        page.gotoCheckout(loginPage);
        page.enterCheckoutInfo();
        page.click(page.finishBtn);

        String expectedMsg = "Thank you for your order!";
        page.assertEquals(page.confirmationMsg.getText() ,expectedMsg);
    }
}

