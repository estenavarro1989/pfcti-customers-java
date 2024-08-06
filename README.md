# pfcti-customers-core

## Prueba Técnica para PFCTI (Java)

### Stack Tecnológico

* Java JDK 17
* PostgreSQL 16.3
* Postman 11.6.1
* Docker 27.1.1
* Visual Studio Code 1.92

### Visual Studio Code Extensions

* [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
* [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
* [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)
* [Project Manager for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency)
* [Rest Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)
* 
### Pasos para ejecutar el proyecto

1. Desde la raíz del proyecto, ejecutar el siguiente comando en consola:

    `docker compose up`

    Al finalizar levantará el postgres con la estructura necesaria en el puerto 5433 y el API de Customers en el puerto 8080

2. Ejecutar las pruebas desde Postman o utilizando la extensión Rest Cliente de VS Code

* Utilizar el archivo `pfcti-customers-java.postman_collection.json` e importarlo en el programa Postman
* Utilizar el archivo test-customers.http directamente desde VS Code utilizando la extensión Rest Client

### Ejecutar Pruebas Unitarias

1. Ir a directorio de Tests
2. Ejecutar el siguiente comando:

    `mvn test`

### Ejecutar desde la Consola

1. Tener desplegado en docker el proyecto con `docker compose up`
2. Ir a la carpeta app y ejecutar el siguiente comando:

    `javac *.java && java App`    

3. En caso de ser necesario, si necesita eliminar los archivos .class, puede urilizar el siguiente comando:
  
    `rm $(find . -name "*.class")`    
