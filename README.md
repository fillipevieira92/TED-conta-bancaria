<div align="center">
  <img src="/src/main/resources/static/img/logo-amarelo.png">
</div>
 
# Descrição
Projeto desenvolvido para um trabalho de faculdade, onde é solicitado um algoritmo bancário que se possa cadastrar clientes e realizar transações financeiras.

# Rodando a aplicação
O projeto é desenvolvido em Java versão 18, utilizando o Maven. Para rodar a aplicação vá até pasta do projeto no terminal e envie o comando:<br> 

<br>

>$ `mvn spring-boot:run`

<br>

![build-logs](https://user-images.githubusercontent.com/90570370/169057847-a34f6cef-2196-4ca4-ab14-7a71a422ec0c.png)

<!-- 
# Rodando a aplicação com Docker
Necessário ter o maven instalado.<br>
Vá até a pasta do projeto no terminal e envie os seguintes comandos:<br>

<br>

>$ `sudo mvn package`
###### * Baixar todas as dependecias, criar o arquivo JAR e rodar o Dockerfile (criando a imagem):

<br>

>$ `sudo docker images`
###### * Listar todas as imagens disponíveis e procurar o ID da imagem com nome = 'uniesp/ted/bank':

<br>

>$ `sudo docker run -p 8080:8080 ID-DA-IMAGEM`
###### * Rodar o container na porta 8080:

<br>
 -->
# Visualizando o site
Depois de rodar o sistema, ele estará disponível no <a target="_blank" href="http:127.0.0.1:8080">localhost</a>

![image](https://user-images.githubusercontent.com/90570370/169057573-db4aa74c-ed4b-4c57-8e3e-1e63311c46c4.png)

# Visualizando o banco de dados
O banco de dados fica disponível no link nativo do <a target="_blank" href="http:127.0.0.1:8080/h2-console">h2-database</a><br>
Para acessar os dados preencha os campos a seguir com os seguintes dados:<br>

- `JDBC URL:`   jdbc:h2:file:./data/exemplo<br>
- `User Name:` admin<br>
- `Password:`   admin

<br>


# Tecnologias utilizadas
#### Back-End:
 - Java 18
 - SpringBoot
 - Maven

#### Front-End:
 - HTML5
 - JavaScript
 - JQuery
 - Requisições AJAX
 - CSS3
 - Bootstrap
