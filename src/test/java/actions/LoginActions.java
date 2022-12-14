package actions;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.LoginPage;

public class LoginActions {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    public void goToLogin(String cliente){
        loginPage.abreTelaDeLogin();
        loginPage.selecionarCliente(cliente);
    }
    public void loginAndSenha(String login, String senha){
        loginPage.inserirLogin(login);
        loginPage.inserirSenha(senha);
        loginPage.clicarEntrar();
    }

    public void checaTituloPagina() {
        loginPage.checaTituloPagina();
    }

    public void loginWith(String cliente, String login, String senha) {
        loginPage.loginWith(cliente, login, senha);
    }
}
