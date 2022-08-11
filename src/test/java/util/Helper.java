package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class Helper {

    private long timeSlice = 15;
    private long tentativas = 0;
    public static final Boolean NOT_EXCEPTION = true;
    public static final Boolean EXCEPTION = true;

    public Helper() {
        PageFactory.initElements(BasePage.getDriver(), this);
    }

    public void preencherCampo(WebElement campoInput, String campoValor){
        if(isVisible(campoInput,"")){
            campoInput.sendKeys(campoValor);
        }
    }
    public void clicarBotao(WebElement botao){
        if(isVisible(botao,"")){
            botao.click();
        }
    }
    public boolean isVisible(WebElement webElement, String text){
        return isView(webElement, text, EXCEPTION);
    }
    public void selecionaCampo(WebElement campoSelect, String text){
        if(isVisible(campoSelect,"")){
            Select sel = new Select(campoSelect);
            sel.selectByVisibleText(text);
        }
    }

    protected boolean isView(WebElement webElement, String text, Boolean hasException){
        try{
            WebDriverWait esperar = new WebDriverWait(BasePage.getDriver(), this.timeSlice);
            esperar.until(ExpectedConditions.visibilityOfAllElements(webElement));
            return webElement.isDisplayed() && webElement.getText().contains(text);
        } catch (Exception e) {
            if(!hasException) {
                return false;
            }
            if(++tentativas >= 3){
                tentativas = 0;
                throw new RuntimeException();
            }
            return isView(webElement, text, hasException);
        } finally {

        }
    }

    public void checaTituloPagina(String tituloPagina) {
        boolean isPagina = BasePage.getDriver().getTitle().contains(tituloPagina);
    }
}
