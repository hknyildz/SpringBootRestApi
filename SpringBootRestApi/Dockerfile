FROM openjdk:15 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:15
WORKDIR SpringBootApi
COPY --from=build target/*.jar SpringBootRestApi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","SpringBootRestApi-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080