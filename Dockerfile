# syntax=docker/dockerfile:1

FROM maven:3.8.6-jdk-11-slim AS build
COPY src ./src
COPY pom.xml ./
RUN mvn -f ./pom.xml clean package

FROM openjdk:17-alpine3.13
COPY --from=build ./target/todo-app-0.0.1-SNAPSHOT.jar /usr/local/lib/todo-app-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/todoApp.jar"]
