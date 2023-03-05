package tests;

import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    LoginPage page;
    @BeforeMethod
    public void setUp() {
        page = new LoginPage(driver);
    }
}
