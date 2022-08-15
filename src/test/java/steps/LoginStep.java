package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import functionalities.LoginFuncionalities;

public class LoginStep {

    LoginFuncionalities loginFuncionalities = new LoginFuncionalities();
    @Dado("^que já esteja logado no cliente \"([^\"]*)\" com o cpf \"([^\"]*)\" e a senha \"([^\"]*)\"\\.$")
    public void loginWith(String arg1,String arg2,String arg3) throws Throwable {
        loginFuncionalities.doLoginWith(arg1, arg2, arg3);
    }
    @Dado("^que o cliente esteja na tela de login do municipio de \"([^\"]*)\"\\.$")
    public void que_o_cliente_esteja_na_tela_de_login_do_municipio(String arg1) throws Throwable {
        loginFuncionalities.goToLogin(arg1);
    }

    @Quando("^realizo o login com o usuário \"([^\"]*)\" e senha \"([^\"]*)\"\\.$")
    public void realizo_o_login_com_o_usuário_e_senha(String arg1, String arg2) throws Throwable {
        loginFuncionalities.doLogin(arg1,arg2);
    }

    @Então("^devo ver a página home\\.$")
    public void devo_ver_a_página_home() throws Throwable {
        loginFuncionalities.doChecaTituloPagina();
    }

}
