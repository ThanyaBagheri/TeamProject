package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest{
    HomePage page;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        page = new HomePage(driver);
    }
    @DataProvider(name = "followingbtns")
    public Object[] testData() {
        Object[] data = {"All Items", "About", "Logout", "Reset App State"};
        return data;
    }

    @Test(dataProvider = "followingbtns",testName = "I need an option to see navigation menu. When user clicks the button it should display following buttons")
    public void test304(String expected){
    // login
        loginPage.login();
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
