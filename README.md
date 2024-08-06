# pfcti-customers-core

## Prueba Técnica para PFCTI (Java)

### Stack Tecnológico

* Java JDK 17
* PostgreSQL 16.3
* Postman 11.6.1
* Docker 27.1.1

### IDE Utilizado

* Visual Studio Code 1.92

### Visual Studio Code Extensions

* [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
* [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
* [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)
* [Project Manager for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency)
* [Rest Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)
  
### Pasos para desplegar el proyecto en docker

1. Desde la raíz del proyecto, ejecutar el siguiente comando en consola:

    `docker compose up`

2. Al finalizar levantará el postgres con la estructura necesaria en el puerto 5433 y el API de Customers en el puerto 8080

### Pasos para realizar pruebas desde Postman

1. Abrir postman
2. Importar el archivo `pfcti-customers-java.postman_collection.json` desde postman
3. Ejecutar los endpoints desde postman

### Pasos para realizar pruebas desde Rest Client

1. Abrir VS Code
2. Tener instalado la extensión [Rest Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)
3. Ir al archivo `test-customers.http` y ejecutar los endpoints
4. Para ejeccutar cada endpoint, debajo del comentario con los numerales (####), se debe de presionar la opción Send Request

### Ejecutar Pruebas Unitarias

1. Verificar que maven esté instalado en la máquina con el siguiente comando (Ver [Instalar Maven](https://www.baeldung.com/install-maven-on-windows-linux-mac):

    `mvn -version`

2. Ejecutar el siguiente comando desde la raíz del proyecto:

    `mvn test`

### Ejecutar la Consola

1. Tener desplegado en docker el proyecto. [Ver Pasos para desplegar el proyecto en docker](#pasos-para-desplegar-el-proyecto-en-docker)
2. Desde el directorio raíz, ir a la carpeta app

    `cd app` 

3. Ejecutar el siguiente comando:

    `javac *.java && java App`    

4. En caso de ser necesario, si desea eliminar los archivos .class, puede utilizar el siguiente comando:
  
    `rm $(find . -name "*.class")`    


### API Endpoints

## POST /api/customers

Agrega un nuevo cliente

**Request Ejemplo**
``` 
{
    "id": "123456",
    "firstName": "Paul",
    "lastName": "McCartney",
    "phone": "+50671717171",
    "birthDate": "1942-06-18"
}
```
**Respuesta Ejemplo**
``` 
{
    "id": "123456",
    "firstName": "Paul",
    "lastName": "McCartney",
    "phone": "+50671717171",
    "birthDate": "1942-06-18"
}

o si genera algún error:

{
    "errors": [
        "El id del cliente que desea agregar ya existe"
    ]
}

``` 

## PUT /api/customers/{id}

Edita un cliente

**Parámetros**

| Nombre | Descripción |
| -------------:|:--------:|
| `id` | Id del cliente  |


**Request Ejemplo**
``` 
{
    "firstName": "Paul",
    "lastName": "McCartney",
    "phone": "+50671717171",
    "birthDate": "1942-06-18"
}
```
**Respuesta Ejemplo**
``` 
{
    "id": "123456",
    "firstName": "Paul",
    "lastName": "McCartney",
    "phone": "+50671717171",
    "birthDate": "1942-06-18"
}

o si genera algún error:

{
    "errors": [
        "El cliente que desea consultar no existe"
    ]
}

``` 

## DELETE /api/customers/{id}

Elimina un cliente

**Parámetros**

| Nombre | Descripción |
| -------------:|:--------:|
| `id` | Id del cliente  |


**Respuesta Ejemplo**
``` 
123456
``` 

## GET /api/customers/{id}

Consulta un cliente por el id

**Parámetros**

| Nombre | Descripción |
| -------------:|:--------:|
| `id` | Id del cliente  |

**Respuesta Ejemplo**
``` 
{
    "id": "123456",
    "firstName": "Paul",
    "lastName": "McCartney",
    "phone": "+50671717171",
    "birthDate": "1942-06-18"
}

o si genera algún error:

{
    "errors": [
        "El cliente que desea consultar no existe"
    ]
}

``` 

## GET /api/customers?orderBy={orderBy}

Lista los clientes de acuerdo al parámetro indicado

**Parámetros**

| Nombre | Descripción |
| -------------:|:--------:|
| `orderBy` | Campo por el cual se va a ordenar la lista. Los campos disponibles son: `birthDate`, `id`, `name` |

**Respuesta Ejemplo**
``` 
[
    {
        "id": "133333333",
        "firstName": "Alejandro Esteban",
        "lastName": "Navarro Sanchez",
        "phone": "+50683838383",
        "birthDate": "1989-04-18"
    },
    {
        "id": "122345632",
        "firstName": "Paul",
        "lastName": "McCartney",
        "phone": "+50671717171",
        "birthDate": "1942-06-19"
    },
    {
        "id": "1234562",
        "firstName": "Paul",
        "lastName": "McCartney",
        "phone": "+50671717171",
        "birthDate": "1942-06-18"
    },
    {
        "id": "123456",
        "firstName": "Paul",
        "lastName": "McCartney",
        "phone": "+50671717171",
        "birthDate": "1942-06-18"
    }
]

``` 
