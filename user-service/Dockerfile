FROM openjdk:24
WORKDIR /app
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]