# Agenda com Interface Gráfica em Java

Este projeto implementa uma agenda de contatos simples com uma interface gráfica utilizando a biblioteca Swing em Java. A aplicação permite adicionar, remover e listar contatos, além de verificar se um número de telefone já existe antes de adicionar um novo contato.



## Aprendizados

Dificuldades e Soluções
- Verificação de Telefone Duplicado

  Dificuldade: Garantir que um número de telefone não seja adicionado mais de uma vez à agenda.

  Solução: Foi implementado o método verificarTelefoneExistente que percorre a lista de contatos e verifica se o telefone já está presente antes de adicionar um novo contato.

- Reorganização dos Contatos Após Remoção

   Dificuldade: Após remover um contato, o espaço deixado deve ser preenchido com os contatos subsequentes para evitar lacunas.

  Solução: Implementado o método remover para limpar o contato removido e, em seguida, reorganizar os contatos subsequentes para preencher o espaço vazio.

 - Interface Gráfica

    Dificuldade: Criar uma interface gráfica intuitiva e funcional para interação  com o usuário.

    Solução: Utilizando a biblioteca Swing, foi criado um layout simples com campos de entrada e uma área de texto para exibir os contatos. A interface inclui botões para adicionar contatos e exibir os resultados na área de texto.

## Funcionalidades

- **Adicionar Contato**: Permite adicionar um novo contato à agenda com nome, email e telefone. Se o número de telefone já estiver na agenda, uma mensagem de erro é exibida.
- **Remover Contato**: Permite remover um contato da agenda pelo índice. Após a remoção, os contatos são reorganizados para preencher o espaço vazio.
- **Listar Contatos**: Exibe todos os contatos presentes na agenda com seus respectivos índices e nomes.

## Etiquetas

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)
