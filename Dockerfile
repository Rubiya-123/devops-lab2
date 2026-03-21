# Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot jar file into container
COPY target/devops-lab2-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8085

# Command to run the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]