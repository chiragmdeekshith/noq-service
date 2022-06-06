# NoQ - Service

The backend server for the NoQ application. 
Uses Spring Boot - Java 17.

### Database
This application uses H2 in-memory database, so each time the server restarts, all stored data is lost.
The credentials for the in-memory database can be found/modified [here](src/main/resources/application.yaml).
The database console/UI can be accessed once the application is up at:- 

```
http://localhost:8080/h2-console/
```

### Setup

1. Clone the repo
2. In the folder's root directory, run the following command to clean the folder.
   >gradle clean

3. Build the project to generate a boot jar file.
   >gradle bootJar

4. Execute the JAR file present in build/libs folder.
   > java -jar noq-0.0.1-SNAPSHOT.jar

   The application should be running on the port 8080 by default. Can be changed in the [application.yaml](src/main/resources/application.yaml) file if needed.