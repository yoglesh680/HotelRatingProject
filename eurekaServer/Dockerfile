FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ./target/eurekaServer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]