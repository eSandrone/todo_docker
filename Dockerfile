# syntax=docker/dockerfile:1
FROM openjdk:17-alpine3.13
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mwnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=mysql"]
