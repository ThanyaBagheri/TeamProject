package tests;

import org.testng.annotations.BeforeMethod;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest{
    CheckoutPage page;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        page = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
    }
}
