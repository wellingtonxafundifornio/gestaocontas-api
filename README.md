# Essa aplicação foi feita para servir dados a uma aplicação frontend
Nota: Para essa api foi implementos novas funcionalidades sobre a api já existente: https://github.com/wellingtonxafundifornio/gestaocursos-ui

## Acesse o link para baixar e executar o client que complementa esse projeto

https://github.com/wellingtonxafundifornio/gestaocontas-ui.git

### Executando o projeto
 * No arquivo ...\gestaocursos-api\src\main\resources\ `application.properties` coloque as credenciais(`schema, usuário e senha`) do seu banco de dados.;
 * **Via cmd, no diretório** `C:\gestaocursos\gestaocursos-api>` execute o comando `mvn clean package` para fazer o build do projeto;
 * Entre no diretório `C:\gestaocursos\gestaocursos-api\target>` e preencha os comandos abaixo com as credenciais do seu banco de dados 
colocadas no arquivo `application-properties` comandos: 
`java -jar gestaocursos-api-1.0.0-SNAPSHOT.jar --spring.datasource.username={usuario do seu bd} --spring.datasource.password={senha do seu bd} --gestaocursos.origem-permitida=http:{origem da sua aplicação externa(Web, mobile) que vc permitirá se comunicar com sua api}`.
