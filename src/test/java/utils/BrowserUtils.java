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

    public static void switchToNewWindow(WebDriver driver, String title){
        for (String eachID : driver.getWindowHandles()) {
                driver.switchTo().window(eachID);
                sleep(1000L);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public static void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
