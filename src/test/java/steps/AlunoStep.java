package steps;

import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.BasePage;

public class AlunoStep extends BasePage {

    @Before()
    public static void testSetup(Scenario cenario) {
        System.out.println("testSetup");
    }

    @After()
    public static void testTearDown(Scenario cenario) {
        System.out.println("testTearDown");
    }

    @Quando("^eu faço um cadastro de um novo aluno.$")
    public void eu_faço_um_cadastro_de_um_novo_aluno() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("eu_faço_um_cadastro_de_um_novo_aluno");
    }

    @E("^estou com os dados do aluno\\.$")
    public void estou_com_os_dados_do_aluno() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("estou_com_os_dados_do_aluno");
    }

    @Então("^devo ver a mensagem de sucesso.$")
    public void devo_ver_a_mensagem_de_sucesso() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("devo_ver_a_mensagem_de_sucesso");
    }

    @Então("^devo ver este aluno na lista.$")
    public void devo_ver_este_aluno_na_lista() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("devo_ver_este_aluno_na_lista");
    }
}
