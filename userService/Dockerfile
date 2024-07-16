FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ./target/userService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]