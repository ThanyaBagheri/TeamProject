package utils;

import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class BrowserUtils extends BaseTest {
    public static void switchToNewWindow(WebDriver driver){
        for (String eachID : driver.getWindowHandles()) {
            if (!eachID.equals(driver.getWindowHandle()))
                driver.switchTo().window(eachID);
        }
    }
}
