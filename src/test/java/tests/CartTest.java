package tests;

import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.CartPage;
import pages.HomePage;

public class CartTest extends BaseTest {
    CartPage page;
    @BeforeMethod
    public void setUp() {
        page = new CartPage(driver);
    }
}
