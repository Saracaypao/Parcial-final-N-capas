# Imagen base
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiar el JAR
COPY target/parcial-final-n-capas-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la app
EXPOSE 8080

# Arranque
ENTRYPOINT ["java","-jar","app.jar"]
