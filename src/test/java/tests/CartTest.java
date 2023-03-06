package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartTest extends BaseTest {
    CartPage page;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        page = new CartPage(driver);
    }

    @Test(testName = "US309: Add to cart", description = "User should be able to add an item to cart with a click of a button. Added item should be displayed in the Cart view")
    public void test309() {
        //login
        loginPage.login();

        page.addToCartBtn.click();
        page.cartBtn.click();

        Assert.assertTrue(page.item.isDisplayed());
    }

    @Test(testName = "US 310 - Remove from cart", description = "User should be able to remove added item from the cart with a click of a button")
    public void test310() {
        //login
        loginPage.login();

        page.addToCartBtn.click();
        page.cartBtn.click();

        Assert.assertTrue(page.removeFromCartBtn.isEnabled());
    }

    @Test(testName = "US 308 - Checkout: Your Information")
    public void test308(){
        //login
        loginPage.login();
        //Checkout form
        page.click(page.cartBtn);
        page.click(page.checkoutBtn);

        Assert.assertTrue(page.firstNameField.isDisplayed());
        Assert.assertTrue(page.lastNameField.isDisplayed());
        Assert.assertTrue(page.postalCodeField.isDisplayed());
    }
}