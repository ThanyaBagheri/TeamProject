package utils;

import org.openqa.selenium.WebDriver;

public class BrowserUtils extends BaseTest {
    public static void switchToNewWindow(WebDriver driver){
        for (String eachID : driver.getWindowHandles()) {
            if (!eachID.equals(driver.getWindowHandle()))
                driver.switchTo().window(eachID);
        }
    }
}
