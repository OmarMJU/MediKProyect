# Proyecto MediK 

### Entorno que se usó para este proyecto es:

* Eclipse Neon.1a Release (4.6.1).
* pgAdmin 4 PostgreSQL.
* Maven 3.3.9.
* Java 1.8.0.
* OS Mac os x v.10.12.1.
* Apache Tomcat 7.
* DBWrench Database Design & Synchronization v3.3.7.

### Crear la base de datos en pgAdmin con los archivos:

* MediK_db.sql
* paciente_table.sql
* medico_table.sql

### Correr el programa

* Para la conexión de base de datos se necesita el Driver *postgresql-9.4.1212.jre6.jar* que se puede descargar de [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html).
* Una vez descargado el Driver se tiene que copiar a la ruta `$TOMCAT_HOME/lib/`
* El proyecto fue creado en Maven y para ellos se usó el comando ```mvn archetype:generate -DgroupId=com.test -DartifactId=MediK -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false```
* Para poder trabajar el proyecto desde Eclipse se tiene que aplicar el comando ```mvn eclipse:eclipse -D wtpversion=1.0``` en la carpeta en donde se creó el proyecto con Maven.
* Teniendo el proyecto en Eclipse, en el *Package Explorer*, damos click derecho sobre la carpeta del proyecto *MediK* `Run As -> Run on server` y selecionamos el servidor que se tenga configurado.
* Una vez que se haya realizado el paso anterior es posible verificarlo en otros navegadores copiando y pegando la URL en el navegador [http://localhost:8080/MediK/](http://localhost:8080/MediK/)
* El archivo *MediK.xml* es un archivo realizado en DBWrench el cual contiene el modelo ER al igual que la imagen *DER.png*.

### Diagrama de BD
![Diagrama de Base de Datos](https://github.com/OmarMJU/MediKProyect/blob/master/DER.png "MediK BD")

### Navegadores

Para poder tener un mejor comportamiento visual de la aplicación se recomienda el uso de:
* Chrome Versión 55.0.2883.95.
* Mozilla Firefox Versión 55.0.2883.95.
* Opera 42.0.2393.94.
* Safari Rev. 2-20-2019 SMR

Por OMJU
