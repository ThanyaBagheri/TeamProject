package tests;

import data.DataProviders;
import org.openqa.selenium.By;
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
        // open about page
        homePage.click(homePage.navMenuBtn);
        homePage.click(homePage.aboutBtn);
        // verify
        boolean check = false;
        for (WebElement each : page.socialMedBtns){
            if(each.getAttribute("href").contains(social)){
                check = true;
                break;
            }
        }
        Assert.assertEquals(check, true);
    }
    @Test(testName = "US 320 - About Page: Navigation Menu")
    public void test320(){
        //login
        loginPage.login();
        // open about page
        homePage.click(homePage.navMenuBtn);
        homePage.click(homePage.aboutBtn);
        //verify
        List<String> navBtns = Arrays.asList("Products", "Pricing", "Developers", "Enterprise","Resources");
        for (String each : navBtns){
            Assert.assertTrue(driver.findElement(By.xpath("//header//span[text()='"+ each + "']")).isEnabled());
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Sign in']")).isEnabled());
    }
}
