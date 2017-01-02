# Proyecto MediK 

Entorno que se usó para este proyecto es:

* Eclipse Neon.1a Release (4.6.1).
* pgAdmin 4 PostgreSQL.
* Maven 3.3.9.
* Java 1.8.0.
* OS Mac os x v.10.12.1.
* Apache Tomcat 7.

Crear la base de datos en pgAdmin con los archivos:

* MediK_db.sql
* paciente_table.sql
* medico_table.sql

Correr el programa

* Para la conección de base de datos se necesita el Driver postgresql-9.4.1212.jre6.jar que se puede descargar de [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html).
* Una vez descargado el Driver se tiene que copiar a la ruta `$TOMCAT_HOME/lib/`
* El proyecto fue creado en Maven y para ellos se usó el comando ```mvn archetype:generate -DgroupId=com.test -DartifactId=MediK -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false```
* Para poder trabajar el proyecto desde Eclipse ```mvn eclipse:eclipse -D wtpversion=1.0```