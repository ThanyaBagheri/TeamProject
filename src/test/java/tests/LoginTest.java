package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    LoginPage page;
    @BeforeMethod
    public void setUp() {

        page = new LoginPage(driver);
    }

    @Test(testName = "US302", description = "locked out user attempt")
    public void test302() {
    driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),
                "Epic sadface: Sorry, this user has been locked out.");

    }
}