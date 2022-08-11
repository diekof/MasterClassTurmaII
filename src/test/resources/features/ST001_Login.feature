#language: pt
#encoding: utf-8

@smoke @TestNG
@severity=blocker
Funcionalidade: Login
  @CredenciaisValidas
  Cenario: Login com sucesso
    Dado que o cliente esteja na tela de login do municipio de "Nova Marilândia".
    Quando realizo o login com o usuário "02312712121" e senha "123456".
    Então devo ver a página home.