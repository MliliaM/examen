# Usa la imagen base de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR compilado de la aplicación a la imagen
COPY target/crud-0.0.1-SNAPSHOT.jar /app

# Define el comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "crud-0.0.1-SNAPSHOT.jar"]
