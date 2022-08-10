package actions;

import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.LoginPage;

public class LoginActions {

    public void goToLogin(){
        new BasePage().openUrl("https://wf.coplan.inf.br/educacao/servlet/login");
    }

    public void loginAndSenha(String login, String senha){

        LoginPage loginPage = new LoginPage();
        loginPage = PageFactory.initElements(BasePage.getDriver(), LoginPage.class);
        loginPage.inserirLogin(login);
        loginPage.inserirSenha(senha);
    }

}
