package util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

public class Hooks extends BasePage{

    @Before()
    public static void suiteSetup(Scenario cenario) {
        openSession("chrome",false);
    }

    @After()
    public static void suiteTearDown(Scenario cenario) {
        close();
    }

}
