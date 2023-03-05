package tests;

import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.HomePage;

public class HomeTest extends BaseTest{
    HomePage page;
    BasePage basePage;
    @BeforeMethod
    public void setUp() {
        page = new HomePage(driver);
    }
}
