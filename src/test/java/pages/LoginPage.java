package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helper;

public class LoginPage {

    @FindBy(id="vUSUARIO_LOGIN")
    private WebElement inputLogin;

    @FindBy(id="vUSUARIO_SENHA")
    private WebElement inputSenha;

    public void inserirLogin(String login){
        inputLogin.sendKeys(login);
    }

    public void inserirSenha(String senha){
        inputSenha.sendKeys(senha);
    }

}
