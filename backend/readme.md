# Requisites
```
Tested with java and jdk version 17 and spring boot 2.7.4
```

# Steps to run
#### In the main directory
```
- mvn clean install
- java -jar target/backend-0.0.1-SNAPSHOT.jar  

```

#### Go to http://localhost:8080/swagger-ui.html
and use either of the two credentials to login
```
- username: admin, password: admin // admin user
- username: client, password: client // normal user
```
##### or just create a new user with /signup endpoint from swagger ui

#### To run the classroom apis
- Signin to get the jwt token
- then click on authorize button to add the token with format "Bearer <token>"
- then you can use the classroom apis

#### Go to http://localhost:8080/h2-console
To seethe h2 database and use the following credentials to login
```
- driver class : org.h2.Driver
- jdbc url : jdbc:h2:mem:classroom
- username : sa
- password : pass
```

