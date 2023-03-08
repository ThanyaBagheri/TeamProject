package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;

import java.util.List;

public class CheckoutTest extends BaseTest{
    CheckoutPage page;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        page = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
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
}
