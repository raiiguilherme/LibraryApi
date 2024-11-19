FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/biblioteca-gerenciamento.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
