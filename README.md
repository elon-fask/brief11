# EMPLOYEE MANAGEMENT SYSTEM
 
# User Registration, User Login and Autorization process.
The diagram shows flow of how we implement User Registration, User Login and Autorization process.

![image](spring-boot-jwt-authentication-spring-security-flow.png)

# Refresh Token
![image](spring-boot-refresh-token-jwt-example-flow.png)

# Configure Spring DataSource, JPA and Application.properties
Open ```/src/main/resources/application.properties```
> For PostgreSQL:
```
spring.datasource.url= jdbc:postgresql://localhost:5432/testdb
spring.datasource.username= postgres
spring.datasource.password= 1234

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

# App Properties
elonfask.app.jwtSecret= bezKoderSecretKey
elonfask.app.jwtExpirationMs= 7200000
```