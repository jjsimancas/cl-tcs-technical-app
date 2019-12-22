# TCS BackEnd

Se procedio al desarrollo de este artefacto para su posterior consumo desde FrontEnd.

# Base de datos
*El nombre de la base de datos es la base de datos por defecto de PostgreSQL postgres

*Segun especificacion de la prueba se debe enviar el archivo SQL con la estructura de la base de datos. 

* Me tome la libertad de automatizar el proceso de creacion de la tabla necesaria para la ejecucion de este artefacto
con la herramienta Liquibase. Al levantar el artefacto este procedera a correr el utilitario disponible y hara la creacion
de la tabla en la base de datos. 

* El motor de base de datos utilizado en el desarrollo y despliegue fue PostgreSQL como se especifica en la seccion de 
pre-requesitos

## Comenzando 🚀

_Para la clonacion de este repositorio es necesario ejecutar el siguiente comando:_

```
git clone https://jjsimancas@bitbucket.org/jjsimancas/cl-tcs-technical-app.git
```

### Pre-requisitos 📋

* [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - version 1.8.0_221
* [maven](https://maven.apache.org/) - version 3.6.0
* [PostgreSQL](https://www.postgresql.org/)- version 8.0.18


### Instalación 🔧
_EL MOTOR DE BASE DE DATOS DEBE ESTAR CORRIENDO CON LA BASE DE DATOS CREADA. LA GENERACION DE TABLAS SERA AUTOMATICA_.
_POR LO GENERAL LA BASE POR DEFECTO DE POSGRESQL ES POSTGRESS Y YA ESTA EN EL MOTOR. DE NO SER ASI SIMPLEMENTE CREAR
ESTA.

_Ejecutar el comando en la raiz del proyecto para el empaquetado del mismo._

_EN EL ARCHIVO PROPERTIES DEL ARTEFACTO SE ENCUENTRA LA CONFIGURACION DE LA BASE DE DATOS._

```
mvn package
```

## Deployment 📦

_Ejecutar el comando para la ejecucion del artefacto._

```
java -jar target/cl-tcs-technical-app-0.0.1-SNAPSHOT.jar
```

## Variables de entorno
Este artefacto esta configurado para el uso de variables de entorno en caso de querer dockerizarlo.
Por el momento estas se encuentran seteadas en el application.properties con los valores que buscara.

_Las variables de entorno son:_
* BD_HOST
* BD_USERNAME
* BD_PASSWORD

## Especificacion Swagger
```
http://localhost:8080/swagger-ui.html#/

```

## Logging
El logging se encuentra habilitado para visualizacion de traza en consola y generacion
de archivo .log en classpath del proyecto.e

## Prueba Unitaria
Se implemento prueba unitaria del metodo de creacion de registros, donde se mockio dicho 
metodo para la prueba del flujo ya que las sesiones de base de datos no son levantadas
durante tests. Se setea modelo de datos para como el esperado y el mock realiza el 
flujo para luego ejecura un Assert el cual dio resultado positivo.
  
  

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Spring Boot](https://spring.io) - 2.2.0.RELEASE
* [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - version 1.8.0_221
* [maven](https://maven.apache.org/) - 3.6.0
* [MySQL](https://www.mysql.com/) - 8.0.18


## Autor ✒️

_Aplicativo para optar a cargo de desarrollador para la empresa Azurian_

* **Juan Simancas** - *Desarrollador FullStack* - [jjsimancas](https://github.com/jjsimancas)

