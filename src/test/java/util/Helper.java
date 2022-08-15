package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;


public class Helper extends BasePage {
    private long timeSlice = 45;
    private long tentativas = 0;
    public static final Boolean NOT_EXCEPTION = true;
    public static final Boolean EXCEPTION = true;
    public void preencherCampo(WebElement campoInput, String campoValor){
        if(isVisible(campoInput,"")) {
            String textoInseridoRetorno = getInsertValue(campoInput, campoValor);
            Assert.assertEquals(textoInseridoRetorno,campoValor);
        }
    }
    protected String getInsertValue(WebElement campoInput, String campoValor){
            campoInput.sendKeys(campoValor);
            String textoInserido = campoInput.getAttribute("value");
            if(textoInserido.isEmpty()){
                if(++tentativas >= 4){
                    tentativas = 0;
                    throw new RuntimeException("Elemento não encontrado.");
                }
                esperaUmTempoAi(2);
                textoInserido = getInsertValue(campoInput,campoValor);
            }
            return textoInserido;
    }
    public void esperaUmTempoAi(int tempoSegundos){
        WebDriverWait esperar = new WebDriverWait(getDriver(), this.timeSlice);
        esperar.withTimeout(Duration.ofSeconds(tempoSegundos));
    }
    public void clicarBotao(WebElement botao){
        if(isVisible(botao,"")){
            botao.click();
        }
    }
    public boolean isVisible(WebElement webElement, String text){
        return isView(webElement, EXCEPTION);
    }
    public void selecionaCampo(WebElement campoSelect, String text){
        if(isVisible(campoSelect,"")){
            Select sel = new Select(campoSelect);
            sel.selectByVisibleText(text);
        }
    }
    protected boolean isView(WebElement webElement, Boolean hasException){
        try{
            WebDriverWait esperar = new WebDriverWait(getDriver(), this.timeSlice);
            esperar.until(ExpectedConditions.visibilityOfAllElements(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
//            if(!hasException) {
//                return false;
//            }
            if(++tentativas >= 3){
                tentativas = 0;
                throw new RuntimeException("Elemento não encontrado.");
            }
            return isView(webElement, hasException);
        }
    }
    public void checaTituloPagina(String expectedTitulo) {
        String tituloObtido = getDriver().getTitle();
        Assert.assertEquals(tituloObtido,expectedTitulo);
    }
    public boolean isTelaLogin(){
        return getDriver().getTitle().equals("Sistema de Gestão Educacional - Gextec");
    }
    public void esperaPaginaSerCarregada(){
        WebDriverWait esperar = new WebDriverWait(BasePage.getDriver(), 60);
        esperar.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
