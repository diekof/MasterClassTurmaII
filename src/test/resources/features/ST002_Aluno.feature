#language: pt
#encoding: utf-8
@smoke
Funcionalidade: Manutenção de aluno

  Contexto:
    Dado que já esteja logado no cliente "Alta Floresta" com o cpf "880.186.602-04" e a senha "Ana123@123".

  Cenario: Cadastro de um novo aluno com sucesso.
    E estou com os dados do aluno.
    Quando eu faço um cadastro de um novo aluno.
    Então devo ver a mensagem de sucesso.
    E devo ver este aluno na lista.

  Cenario: Alterando dados de um aluno com sucesso.
    E estou com os dados do aluno.
    Quando eu faço um cadastro de um novo aluno.
    Então devo ver a mensagem de sucesso.
    E devo ver este aluno na lista.

  Cenario: Escluindo dados de um aluno com sucesso.
    E estou com os dados do aluno.
    Quando eu faço um cadastro de um novo aluno.
    Então devo ver a mensagem de sucesso.
    E devo ver este aluno na lista.