# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY MultiplicationGame.jar /app/MultiplicationGame.jar

# Expose the port if the application uses one (optional, remove if not needed)
# EXPOSE 8080

# Specify the command to run the JAR file
CMD ["java", "-jar", "MultiplicationGame.jar"]