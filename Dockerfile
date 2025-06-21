FROM eclipse-temurin:21
LABEL authors="jefferson"
COPY ./build/libs/biblioteca-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]