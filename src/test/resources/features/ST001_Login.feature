#language: pt
#encoding: utf-8

@smoke
@severity=blocker
Funcionalidade: Login
  @CredenciaisValidas
  Cenario: Login com sucesso
    Dado que o cliente esteja na tela de login do municipio de "Alta Floresta".
    Quando realizo o login com o usuário "880.186.602-04" e senha "Ana123@123".
    Então devo ver a página home.