package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static WebDriver driver;

    public void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }

    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Des\\arquivos\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void close(){
        driver.quit();
        driver = null;
    }
    public void openEdge(){
        driver = new EdgeDriver();
    }

    public void openSession(String navegador){
        switch (navegador){
            case "chrome":
                openChrome();
                break;
            case "edge":
                openEdge();
                break;
            default:
                throw new RuntimeException();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public static byte[] getScreenshot(){
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

}
