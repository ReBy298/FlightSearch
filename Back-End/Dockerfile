# Etapa de construcción
FROM eclipse-temurin:17-jdk as builder
WORKDIR /Back-End

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew clean build --no-daemon



# Etapa de ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /Back-End
COPY --from=builder /Back-End/build/libs/Back-End-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/Back-End/app.jar"]
