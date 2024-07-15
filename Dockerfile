# Use a base image with Java runtime environment
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/springbootmonogo.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
