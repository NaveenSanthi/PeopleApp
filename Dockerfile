FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/userApp-0.0.1-SNAPSHOT.jar userApp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","userApp.jar"]
