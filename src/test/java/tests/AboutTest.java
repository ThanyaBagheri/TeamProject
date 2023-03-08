package tests;

import data.DataProviders;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class AboutTest extends BaseTest{
    AboutPage page;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp(){
        page = new AboutPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @Test(testName = "US 319 - About Page: Social media buttons", dataProvider = "socialMed names", dataProviderClass = DataProviders.class)
    public void test319(String social){
        //login
        loginPage.login();
        // verify buttons
        homePage.click(homePage.navMenuBtn);
        homePage.click(homePage.aboutBtn);

        boolean check = false;
        for (WebElement each : page.socialMedBtns){
            if(each.getAttribute("href").contains(social)){
                check = true;
                break;
            }
        }
        Assert.assertEquals(check, true);




    }
}
