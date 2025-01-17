# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY MultiplicationTableGame.jar /app

# Expose a port if necessary (optional, e.g., 8080 for web-based apps)
EXPOSE 8080

# Command to run the Java application
CMD ["java", "-jar", "MultiplicationTableGame.jar"]