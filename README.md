# Dog API - Automated API Testing

## Objetivo

Validar o correto funcionamento dos endpoints da Dog API
(https://dog.ceo/dog-api/) e verificar se retornam os códigos HTTP,
formatos de resposta e dados esperados, além de identificar
comportamentos inesperados e avaliar desempenho (tempo de resposta).

### Base URL

`https://dog.ceo/api`

### Endpoints testados

- `GET /breeds/list/all`
- `GET /breed/{breed}/images`
- `GET /breeds/image/random`

------------------------------------------------------------------------

## Sobre o projeto

Este projeto automatiza testes funcionais e de validação de API utilizando boas práticas de 
testes automatizados, incluindo cenários positivos, negativos e validação de performance.

Os testes foram desenvolvidos com foco em confiabilidade, legibilidade e fácil manutenção.

------------------------------------------------------------------------

## Pré-requisitos

-   Java JDK 17 ou superior\
-   Maven 3.8 ou superior\
-   IDE recomendada: IntelliJ IDEA
-   Framework de testes: JUnit 5
-   Biblioteca de API: RestAssured

------------------------------------------------------------------------

## Execução e Relatório

### Via linha de comando

``` bash
git clone <URL_DO_REPOSITORIO>
cd <nome_do_diretorio_clonado>
mvn clean install
mvn clean test site -Dmaven.test.failure.ignore=true
```

Após a execução, o relatório HTML estará disponível em:

`target/site/surefire-report.html`

------------------------------------------------------------------------

## Execução via IDE

1.  Clone o repositório
2.  Abra o projeto no IntelliJ
3.  Execute as classes de teste com botão direito → Run

------------------------------------------------------------------------

## Relatório Manual

Além do relatório automático gerado pelo Maven, foi elaborado um relatório manual contendo:

- Descrição dos cenários de teste
- Resultados obtidos (sucesso e falha)
- Análise detalhada das falhas
- Considerações sobre desempenho
- Sugestões de melhoria

Arquivo disponível na raiz do projeto:
`relatorio_testes_api.docx`

------------------------------------------------------------------------

## Estrutura dos testes

### Testes positivos

-   Status code 200
-   Campo "status" igual a "success"
-   JSON não vazio
-   Content-Type correto
-   Lista com itens
-   URLs válidas
-   Tempo de resposta abaixo de 3 segundos

------------------------------------------------------------------------

### Testes negativos

-   Endpoint inválido (404)
-   Método HTTP incorreto (405)
-   URL mal formada
-   Raça inválida
-   Tempo de resposta fora do limite definido

------------------------------------------------------------------------

## Testes de performance

-   Cenários positivos: até 3 segundos
-   Cenários negativos: limite menor (ex: 300ms)

Observação: Por se tratar de uma API pública, o tempo de resposta pode variar

------------------------------------------------------------------------

## Integração Contínua (CI)

O projeto utiliza GitHub Actions para execução automática dos testes.

-   A cada push, os testes são executados automaticamente
-   Um relatório HTML é gerado como artefato

### Como acessar o relatório no CI:

1.  Vá até a aba Actions
2.  Selecione a execução mais recente
3.  Baixe o artefato test-report
4.  Abra o arquivo surefire-report.html
