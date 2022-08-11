package functionalities;

import actions.LoginActions;

public class LoginFuncionalities {

    LoginActions loginActions = new LoginActions();
    public void goToLogin(){
        loginActions.goToLogin();
    }
    public void doLogin(String login, String senha){
        loginActions.loginAndSenha(login, senha);
    }

}
