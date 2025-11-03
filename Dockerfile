# Etapa 1: construir el proyecto
FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Etapa 2: ejecutar el JAR compilado
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
