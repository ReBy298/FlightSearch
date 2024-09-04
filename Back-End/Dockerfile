# Etapa de construcción
FROM eclipse-temurin:17-jdk
WORKDIR /Back-End

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew clean build --no-daemon
RUN ls -la
RUN ls -la build
RUN ls -la build/libs
RUN pwd



# Etapa de ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /Back-End
COPY build/libs/Back-End-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/Back-End/app.jar"]
