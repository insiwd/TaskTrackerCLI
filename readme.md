# TaskTrackerCLI

> TaskTrackerCLI é um simples sistema de gerenciamento de tarefas desenvolvido em Java para ser usado via linha de comando. O programa permite que você adicione tarefas ao seu repositório de tarefas, além de fazer isso de maneira interativa. Ao adicionar uma tarefa, a descrição é armazenada em um arquivo JSON local.

## 📝 Funcionalidades 

- **Adicionar Tarefas**: O usuário pode adicionar tarefas com uma descrição através do comando `todo add <descricao>`.
- **Persistência em JSON**: As tarefas são salvas em um arquivo `tasks.json`.
- **Interatividade**: O programa solicita ao usuário que insira os comandos diretamente via terminal.
- **Exit**: O programa permite sair digitando o comando `sair`.

## ⚙️ Pré-requisitos 

- **Java 11+**: Este projeto requer o Java 11 ou superior para ser executado.
- **Bibliotecas**:
  - **Gson**: Usado para manipulação e serialização de JSON.
  - **Scanner**: Usado para capturar entradas do usuário via linha de comando.

## 📦 Instalação

```
javac Main.java
java Main
```

## 💻 Pré Requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

```
- Java JDK 17+
- Você tem uma máquina Windows / Linux / Mac
- Você conhece o git
```

## 📫 Contribuindo para TaskTrackerCLI

Para contribuir com TaskTrackerCLI, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <nome_branch>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_repo>`.
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).
