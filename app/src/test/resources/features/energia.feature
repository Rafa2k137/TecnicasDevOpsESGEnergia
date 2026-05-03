Funcionalidade: Gestão de consumo energético

  Cenário: Cadastro de consumo válido
    Dado que a API está disponível
    Quando eu envio um POST para "/energia" com dados válidos
    Então o status da resposta deve ser 201
    E o corpo da resposta deve conter o campo "id"

  Cenário: Cadastro com dados inválidos
    Dado que a API está disponível
    Quando eu envio um POST para "/energia" com dados inválidos
    Então o status da resposta deve ser 400

  Cenário: Buscar consumo existente
    Dado que existe um consumo cadastrado
    Quando eu envio um GET para "/energia/1"
    Então o status da resposta deve ser 200