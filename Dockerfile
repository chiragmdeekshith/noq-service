FROM openjdk:17
EXPOSE 8080
ADD build/libs/noq-service.jar noq-service.jar
ENTRYPOINT ["java","-jar","/noq-service.jar"]