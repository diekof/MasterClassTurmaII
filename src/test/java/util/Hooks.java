package util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

public class Hooks extends BasePage{

    @Before(order = 0)
    public static void suiteSetup(Scenario cenario) {
        openSession("chrome");
    }

    @After(order = 1)
    public static void suiteTearDown(Scenario cenario) {
        close();
    }
}
