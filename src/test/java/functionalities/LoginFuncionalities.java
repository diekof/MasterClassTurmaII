package functionalities;

import actions.LoginActions;

public class LoginFuncionalities {
    public void goToLogin(){
        new LoginActions().goToLogin();
    }
    public void doLogin(String login, String senha){
        new LoginActions().loginAndSenha(login, senha);
    }

}
