package data;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "followingbtns")
    public Object[] testData() {
        Object[] data = {"All Items", "About", "Logout", "Reset App State"};
        return data;
    }

    @DataProvider(name = "socialMed")
    public Object[] socialMed() {
        Object[] social = {"Sauce Labs (@saucelabs) / Twitter","Sauce Labs | Facebook","Sauce Labs | LinkedIn"};
        return social;
    }
}
