# Base JDK image
from openjdk:17

# Set work directory
workdir /app

# Copy application to workdir
copy target/OpenShiftLearn-1.0.jar /app/application.jar

# Start command
cmd ["java", "-jar", "application.jar"]

# Build: docker build -t openshiftlearn:latest .
# Local test: docker run -p 8080:8080 openshiftlearn:latest