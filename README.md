# Projeto de Testes Automatizados com Cucumber e JUnit

## Descrição

Este projeto é um exemplo de testes automatizados utilizando Cucumber e JUnit para testar funcionalidades de busca em um blog. O projeto está configurado para usar Maven como ferramenta de build e gerenciamento de dependências.

## Estrutura do Projeto

- `src/test/java/com/missio/agi/runners/TestRunner.java`: Classe que configura e executa os testes Cucumber.
- `src/test/resources/features/blog.feature`: Arquivo de especificação de funcionalidades em Gherkin.
- `pom.xml`: Arquivo de configuração do Maven, incluindo dependências e plugins necessários.

## Dependências

As principais dependências utilizadas neste projeto são:

- `commons-io:2.16.1`
- `io.cucumber:cucumber-junit-platform-engine:7.18.1`
- `org.junit.platform:junit-platform-suite-api:1.10.1`
- `io.cucumber:cucumber-junit:7.18.1`
- `org.apache.maven.plugins:maven-surefire-plugin:3.2.5`
- `io.qameta.allure:allure-maven:2.12.0`
- `org.apache.maven.plugins:maven-failsafe-plugin:3.2.5`

## Configuração do Maven

O arquivo `pom.xml` está configurado para incluir as dependências e plugins necessários para a execução dos testes. Os plugins `maven-surefire-plugin` e `maven-failsafe-plugin` são utilizados para a execução de testes unitários e de integração, respectivamente.

## Executando os Testes

Para executar os testes, utilize o seguinte comando Maven:

```sh
mvn clean test
