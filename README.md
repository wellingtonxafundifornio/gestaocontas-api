# Sobre o projeto

Esse projeto dividi-se em duas partes: **"backend e frontend"**. Essa parte é a **backend (API)**. 
Nesse **design** a separação dos papeis se torna clara e simples de se entender, alem de facilitar o desenvolvimento, sendo possível 
subir/executar o `projeto backend ou forntend` de forma `independente`. Que por concequencia também possibilita que
para esse backend possa existir varios frontends. Ex: "Para esse projeto backend posso ter uma client mobile, 
web, etc". Nesse case tenho um client web desenvolvido com angular 4.

## Acesse o link para baixar e executar o client que complementa esse projeto

gestaocursos-ui: https://github.com/wellingtonxafundifornio/gestaocursos-ui

### Executando o projeto
 * No arquivo ...\gestaocursos-api\src\main\resources\ `application.properties` coloque as credenciais do seu banco de dados.;
 * **Via cmd, no diretório** `C:\gestaocursos\gestaocursos-api>` execute o comando `mvn clean package` para fazer o build do projeto;
 * Entre no diretório `C:\gestaocursos\gestaocursos-api\target>` e preencha os comandos abaixo com as credenciais do seu banco de dados 
colocadas no arquivo `application-properties` comandos: 
`java -jar gestaocursos-api-1.0.0-SNAPSHOT.jar --spring.datasource.username={usuario do seu bd} --spring.datasource.password={senha do seu bd} --gestaocursos.origem-permitida=http:{origem da sua aplicação externa(Web, mobile) que vc permitirá se comunicar com sua api}`.
