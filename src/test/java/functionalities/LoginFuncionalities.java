package functionalities;

import actions.LoginActions;

public class LoginFuncionalities {

    LoginActions loginActions = new LoginActions();
    public void goToLogin(String cliente){
        loginActions.goToLogin(cliente);
    }
    public void doLogin(String login, String senha){
        loginActions.loginAndSenha(login, senha);
    }
    public void doChecaTituloPagina(){
        loginActions.checaTituloPagina();
    }

    public void doLoginWith(String cliente, String login, String senha){
        loginActions.loginWith(cliente, login, senha);
    }

}
