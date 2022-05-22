<div align="center">
  <img src="/src/main/resources/static/img/logo-extenso-amarelo.png">
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

![image](https://user-images.githubusercontent.com/90570370/169720075-edd8bac2-bde4-4e64-a9d2-cc9ec05c04b9.png)
![image](https://user-images.githubusercontent.com/90570370/169720140-284895dd-9c31-43c9-9705-b9cf15d4676d.png)
![image](https://user-images.githubusercontent.com/90570370/169720178-247dd984-3eb5-4d0b-bb27-09edf092390d.png)


# Visualizando o banco de dados
O banco de dados fica disponível no link nativo do <a target="_blank" href="http:127.0.0.1:8080/h2-console">h2-database</a><br>
Para acessar os dados preencha os campos a seguir com os seguintes dados:<br>

- `JDBC URL:`   jdbc:h2:file:./data/exemplo<br>
- `User Name:` admin<br>
- `Password:`   admin

<br>

![image](https://user-images.githubusercontent.com/90570370/169720272-4cee217e-3052-4a79-8f96-0c37b39f3ea7.png)



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
