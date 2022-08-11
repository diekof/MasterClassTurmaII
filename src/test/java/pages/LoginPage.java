package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helper;

public class LoginPage{

    @FindBy(id = "vCLIENTE")
    private WebElement selectCliente;
    @FindBy(id="vUSUARIO_LOGIN")
    private WebElement inputLogin;
    @FindBy(id="vUSUARIO_SENHA")
    private WebElement inputSenha;
    @FindBy(id = "BTNENTER")
    private WebElement btnEntrar;

    private String tituloPagina = "Principal";

    @FindBy(className = "TableHeaderText")
    private WebElement textoUsuarioLogado;

    private Helper helper = new Helper();

    public LoginPage() {
        PageFactory.initElements(BasePage.getDriver(), this);
    }
    public void selecionarCliente(String cliente){
        helper.selecionaCampo(selectCliente,cliente);
    }
    public void inserirLogin(String login){
        helper.preencherCampo(inputLogin,login);
    }

    public void inserirSenha(String senha){
        helper.preencherCampo(inputSenha,senha);
    }

    public void clicarEntrar(){
        helper.clicarBotao(btnEntrar);
    }

    public void checaTituloPagina() {
        if(helper.isVisible(textoUsuarioLogado,""))
            helper.checaTituloPagina(tituloPagina);
    }
}
