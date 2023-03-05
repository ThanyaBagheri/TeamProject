package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class HomeTest extends BaseTest{
    HomePage page;
    BasePage basePage;
    @BeforeMethod
    public void setUp() {
        page = new HomePage(driver);
    }
    @DataProvider(name = "followingbtns")
    public Object[] testData() {
        Object[] data = {"All Items", "About", "Logout", "Reset App State"};
        return data;
    }

    @Test(dataProvider = "followingbtns",testName = "I need an option to see navigation menu. When user clicks the button it should display following buttons")
    public void test01(String expected){
    // login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // nav-menu
        page.navMenuBtn.click();

        boolean check = false;
        for (int i = 0; i < page.followingBtns.size(); i++) {
            String actual = page.followingBtns.get(i).getText();
            if (actual.equals(expected)) {
                check = true;
                break;
            }
        }
        Assert.assertEquals(check, true);


    }
}
