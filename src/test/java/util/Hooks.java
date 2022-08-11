package util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

public class Hooks {

    @Before(order = 0)
    public static void suiteSetup(Scenario cenario) {
        System.out.println(cenario.getName());
        BasePage basepage = new BasePage();
        basepage.openSession("chrome");
    }
    @After(order = 0)
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) new BasePage().getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @After(order = 1)
    public static void suiteTearDown(Scenario cenario) {
        System.out.println(cenario.getName());
        System.out.println(cenario.getStatus());
        System.out.println("Suite Tear Down");
        new BasePage().getDriver().close();
    }
}
