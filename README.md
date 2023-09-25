# Desafio ADA-Cielo-Fullstack - Gerenciamento de Filas de Feedbacks

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Duduudz/adaSala2/blob/main/LICENSE)

## Sobre o projeto

O projeto foi implementado durante a primeira semana de bootcamp da Ada em parceria com a Cielo e visa a criação um serviço que gerencia filas de feedback de sugestões, elogios e críticas de clientes para uma empresa, aproveitando os serviços SNS e SQS da AWS.

## Tecnologias utilizadas

### Back end

- Java
- Spring Boot
- Maven

### Front end

- React.js
- Typescript
- Styled Component
- Material UI
- Axios (para requisicoes HTTP)
- React Context (para gerencimento de estado. Em uma aplicacao mais robusta o indicado seria usar o Redux para gerenciamento de estado para um melhor gerenciamento e escalabilidade)

### Serviços de Cloud

- Simple Queue Service (SQS) da Amazon AWS
- Simple Notification Service (SNS) da Amazon AWS

## Como executar o projeto

### Back end

Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/Duduudz/adaSala2.git

# abra a pasta /backend alguma IDE como o Intelij/VsCode/Eclipse
# instale as dependencias do projeto e rode a aplicacao
# a API ira ser executada no endereco http://localhost:8080

```

#### Endpoints (Implementados)

```
# POST - http://localhost:8080/feedback

Payload (Body)
{
  "type": "CRITICA",
  "message": "Mensagem de Critica"
}

Response
{
   "id": 1,
   "messageId": "bf21d4f2-3b72-57b3-a64e-8978fa3942b8",
   "type": "CRITICA",
   "message": "Mensagem de Critica do Postman",
   "status": "RECEBIDO"
}
```

#### Endpoints (Nao Implementados)

```
# GET - http://localhost:8080/feedback/critica
# GET - http://localhost:8080/feedback/elogio
# GET - http://localhost:8080/feedback/sugestao

Ambos deveriam consumir (buscar/listar) as mensages das suas respectivas filas.
```

### Front end

Pré-requisitos: Node 20

```bash
# clonar repositório
git clone https://github.com/Duduudz/adaSala2.git

# abra a pasta /frontend alguma IDE como o Intelij/VsCode/Eclipse
# instale as dependencias do projeto e rode a aplicacao
yarn

# execute o script start
yarn start

# o frontend ira abrir uma aba em seu navegador com o endereco http://localhost:3000
```

## Autores

Herlander Francisco Sanguluvulo da Silva - https://www.linkedin.com/in/herlander-da-silva/

Lucas Paixão - https://www.linkedin.com/in/lucas-coelho-paixao/

Felipe Maximiliano da Rosa (Back e Front) - https://www.linkedin.com/in/felipemaxrosa

Gustavo S
