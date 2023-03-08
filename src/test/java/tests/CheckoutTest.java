package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.BrowserUtils;

public class CheckoutTest extends BaseTest{
    CheckoutPage page;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        page = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(testName = "US 313 -Checkout Overview - Price Total\n")
    public void test313(){
        // login
        loginPage.login();
        // add to cart
        page.addToCartAllItems();
        //switch to cart page
        page.click(page.shoppingCartBtn);
        //fill checkout form and click continue
        page.fillCheckoutForm();
        //verify
        double item = page.getSumFromString(page.itemTotal);
        double tax = page.getSumFromString(page.tax);
        double total = page.getSumFromString(page.total);

        Assert.assertEquals(total, item + tax);
    }
    @Test(testName = "US 316- Checkout: Complete - Back Home Button")
    public void test316(){

    }


}
