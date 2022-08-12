#language: pt
#encoding: utf-8
@smoke
Funcionalidade: Manutenção de aluno

  Cenario: Cadastro de um novo aluno com sucesso
    Dado que eu esteja um novo aluno
    Quando eu faço um cadastro de um novo aluno
    Então devo ver a mensagem de sucesso
    E devo ver este aluno na lista