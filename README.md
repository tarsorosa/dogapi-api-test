# Teste de API – DOG API

## Objetivo
Validar o correto funcionamento dos endpoints da [Dog API](https://dog.ceo/dog-api/) e verificar se os mesmos retornam os códigos HTTP, 
formatos de resposta e dados esperados, além de testar o desempenho e identificar comportamentos incorretos em situações negativas.
- 'GET /breeds/list/all'
- 'GET /breed/{breed}/images'
- 'GET /breeds/image/random'

## Pré-requisitos
- **Java JDK 17** ou superior (configurado como JDK do projeto na IDE).  
- **Maven 3.8** ou superior.  
- **IDE recomendada:** IntelliJ IDEA 2026.  
- **Frameworks de teste:** JUnit 5, RestAssured.  
- **Dependências:** serão baixadas automaticamente pelo Maven.

## Execução

### Via linha de comando
```
bash
- git clone <URL_DO_REPOSITORIO>
- cd <nome_do_diretorio_clonado>
- mvn clean install
- mvn test (Roda todos os testes)
- mvn test -DtestTags=positivo (Roda apenas testes positivos)
- mvn test -DtestTags=negativos (Roda apenas testes negativos)
```

### Via IDE
1. Clone o repositório e acesse o diretório:
- git clone <URL_DO_REPOSITORIO>
- cd <nome_do_diretorio_clonado>
- mvn clean install
2. Abra o projeto no Intellij
3. Clique com o botão direito na classe desejada e depois na opção "Run" 


## Estrutura dos testes
### Positivos
Verificam se os endpoints estão funcionando corretamente:
- statusCode(200)
- JSON com campo "status" igual a "success"
- JSON não está vazio
- ContentType correto
- Lista de itens não vazia
- URLs das imagens válidas
- Tempo de resposta abaixo de 3 segundos

### Negativos 
Verificam tratamento de erros:
- Endpoint inválido (404)
- Método HTTP incorreto (405)
- URL mal formada (404)
- Raça inválida
- Tempo de resposta fora do limite definido (teste proposital de falha)

## Relatórios com os resultados e considerações dos testes:
Relatório - breeds_list_all.pdf
Relatório - breed_breed_images.pdf
Relatório - breeds_image_random.pdf

