package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.util.Strings;
import util.PropertiesLoader;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static WebDriver driver;
    public void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }
    protected static void openChrome(){
        String pathChromeDriver = Strings.isNullOrEmpty(System.getProperty("path_chrome_driver")) ? new PropertiesLoader("/web.properties").getValue("path_chrome_driver"): System.getProperty("path_chrome_driver");
        System.setProperty("webdriver.chrome.driver",pathChromeDriver);
        driver = new ChromeDriver();
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void close(){
        driver.close();
        driver.quit();
        driver = null;
    }
    protected static void openEdge(){
        driver = new EdgeDriver();
    }
    public static void openSession(String navegador,boolean isMaxmize){
        if(getDriver()==null){
            switch (navegador){
                case "chrome":
                    openChrome();
                    break;
                case "edge":
                    openEdge();
                    break;
                default:
                    throw new RuntimeException("Nenhum navegador encontrado.");
            }
            if(isMaxmize){
                driver.manage().window().maximize();
            }else{
                Dimension dimension = new Dimension(1440,900);
                driver.manage().window().setSize(dimension);
            }
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }
    public void openUrl(String url){
        driver.get(url);
        waitPageLoaded();
    }
    public void waitPageLoaded(){
        WebDriverWait esperar = new WebDriverWait(driver, 60);
        esperar.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
    public static byte[] getScreenshot(){
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

}
