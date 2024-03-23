FROM openjdk:17-jdk-slim
ADD ./target/demojdbc-1.0.0-executable-jar.jar /app.jar
CMD ["java", "-jar", "/app.jar", "-pl", "file:/deployments/config/application.properties"]
EXPOSE 8081
