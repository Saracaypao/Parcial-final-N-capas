# Imagen base
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiar el JAR
COPY target/*.jar app.jar

# Exponer el puerto de la app
EXPOSE 8080

# Arranque
ENTRYPOINT ["java","-jar","app.jar"]
