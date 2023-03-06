package tests;


import org.bouncycastle.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;


import java.util.ArrayList;
import java.util.List;

public class HomeTest extends BaseTest {

import java.util.List;

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

    @Test(dataProvider = "followingbtns", testName = "I need an option to see navigation menu. When user clicks the button it should display following buttons")
    public void test01(String expected) {
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


    @Test(testName = "US305", description = "verifying Footer of the page ")
    public void test305() {
        page.sendKeys(page.usernameInput, "standard_user");
        page.sendKeys(page.passwordInput, "secret_sauce");
        page.click(page.loginBtn);
        String footer = "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='footer_copy']")).getText(), footer);

    }

    @Test(testName = "US306", description = "filter options")
    public void test306() {

        page.sendKeys(page.usernameInput, "standard_user");
        page.sendKeys(page.passwordInput, "secret_sauce");
        page.click(page.loginBtn);

        List<WebElement> options = page.filterOptions;
        List<String> expectedOptions = new ArrayList<>();
        expectedOptions.add("Name (A to Z)");
        expectedOptions.add("Name (Z to A)");
        expectedOptions.add("Price (low to high)");
        expectedOptions.add("Price (high to low)");
        for (WebElement option : options) {
            if (options.size() == expectedOptions.size()) {
                Assert.assertTrue(expectedOptions.get(0).equals(option.getText()));
                Assert.assertTrue(expectedOptions.get(1).equals(option.getText()));
                Assert.assertTrue(expectedOptions.get(2).equals(option.getText()));
                Assert.assertTrue(expectedOptions.get(3).equals(option.getText()));
            }

    @Test(testName = "US 303: When problem_user logs in all items on homepage should display same images")
    public void test303() {
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> pictures = driver.findElements(By.xpath("//img[@class='inventory_item_img']"));
        //pictures.forEach(each -> System.out.println(each.getAttribute("src")) );

        String picturePath = "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg";
        for (WebElement each: pictures){
            Assert.assertEquals(each.getAttribute("src"), picturePath);

        }
    }
}
