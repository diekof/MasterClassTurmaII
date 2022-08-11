package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Então;
import functionalities.LoginFuncionalities;

public class LoginStep {

    LoginFuncionalities loginFuncionalities = new LoginFuncionalities();

    @Dado("^que o cliente esteja na tela de login do municipio de \"([^\"]*)\"\\.$")
    public void que_o_cliente_esteja_na_tela_de_login_do_municipio(String arg1) throws Throwable {
        loginFuncionalities.goToLogin();
    }

    @Quando("^realizo o login com o usuário \"([^\"]*)\" e senha \"([^\"]*)\"\\.$")
    public void realizo_o_login_com_o_usuário_e_senha(String arg1, String arg2) throws Throwable {
        loginFuncionalities.doLogin(arg1,arg2);
    }

    @Então("^devo ver a página home\\.$")
    public void devo_ver_a_página_home() throws Throwable {
        System.out.println("devo_ver_a_página_home");
    }

}
