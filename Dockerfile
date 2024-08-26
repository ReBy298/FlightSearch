# Usa una imagen base de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Gradle al contenedor
COPY build/libs/*.jar app.jar

# Expone el puerto en el que la aplicación Spring Boot se ejecutará
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
