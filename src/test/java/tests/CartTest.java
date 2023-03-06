package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest extends BaseTest {
    CartPage page;
    @BeforeMethod
    public void setUp() {
        page = new CartPage(driver);
    }

    @Test(testName = "US309: Add to cart", description = "User should be able to add an item to cart with a click of a button. Added item should be displayed in the Cart view")
    public void test309() {
        page.sendKeys(page.usernameInput, "standard_user");
        page.sendKeys(page.passwordInput, "secret_sauce");
        page.click(page.loginBtn);

        page.addToCartBtn.click();
        page.cartBtn.click();

        Assert.assertTrue(page.item.isDisplayed());
    }

    @Test(testName = "US 310 - Remove from cart", description = "User should be able to remove added item from the cart with a click of a button")
    public void test310() {
        page.sendKeys(page.usernameInput, "standard_user");
        page.sendKeys(page.passwordInput, "secret_sauce");
        page.click(page.loginBtn);

        page.addToCartBtn.click();
        page.cartBtn.click();

        Assert.assertTrue(page.removeFromCartBtn.isEnabled());
    }
}