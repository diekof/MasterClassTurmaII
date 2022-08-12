package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

public class BasePage {

    private static WebDriver driver;

    public void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }

    public static void openChrome(){
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
    public static void openEdge(){
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
