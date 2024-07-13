# LiterAlura

LiterAlura es una aplicación para la búsqueda y almacenamiento de información de libros obtenida desde una API externa. Utiliza Spring Boot, JPA y PostgreSQL para la persistencia de datos.

## Características

- Búsqueda de libros por título utilizando la API de Gutendex.
- Almacenamiento de información de libros en una base de datos PostgreSQL.
- Listado de autores registrados.
- Relación entre libros y autores en la base de datos.

## Requisitos

- Java 17 o superior.
- Maven 3.6.3 o superior.
- PostgreSQL 12 o superior.
- Internet para acceder a la API de Gutendex.

## Instalación

1. Clona el repositorio:

```bash
git clone https://github.com/tu_usuario/literalura.git
cd literalura
Configura la base de datos PostgreSQL:
```
2.Crea una base de datos llamada literalura.

```
Configura las credenciales de acceso en src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true```
```

3.Compila y ejecuta la aplicación:
```
mvn clean install
mvn spring-boot:run
```

