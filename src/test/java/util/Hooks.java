package util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

public class Hooks {

    @Before(order = 0)
    public static void suiteSetup(Scenario cenario) {
        System.out.println(cenario.getName());
        BasePage basepage = new BasePage();
        basepage.openSession("chrome");
    }

    @After
    public static void suiteTearDown(Scenario cenario) {
        System.out.println(cenario.getName());
        System.out.println(cenario.getStatus());
        System.out.println("Suite Tear Down");
//        new BasePage().getDriver().close();
    }
}
