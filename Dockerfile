# syntax=docker/dockerfile:1
FROM openjdk:17-alpine3.13
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
CMD ["spring-boot:run", "-Dspring-boot.run.profiles=mysql"]
