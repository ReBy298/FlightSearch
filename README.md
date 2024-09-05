# Search Flights App
Search Flights App is a web application built with React TypeScript for the front-end and Spring Boot with Java 17 and Gradle for the back-end. This application utilizes the Amadeus API to search for flights. Users can search for flights and view flight details, but booking or scheduling flights is not supported.

## Project Overview
This project can be built using the docker-compose file. Each of the front-end and back-end has its own Dockerfile. Below are the commands to build, run, and stop the application using either Podman or Docker.

## Docker Commands
### Build the Project
```
podman-compose build
# or
docker-compose build
```
### Run the Project
```
podman-compose up
# or
docker-compose up
```
### Stop the Project
```
podman-compose down
# or
docker-compose down
```

## Front-End: React TypeScript Application
The front-end of this project is a React application written in TypeScript. It runs on localhost at port 3000.

### Running the Application
To start the application, use the following command:
```
npm start
```
### Running Tests
To run the tests for the application, use the following command:
```
npm test
```
### Back-End: Spring Boot Application
The back-end of this project is a Spring Boot application built with Java 17 and Gradle.

### Running the Application
To start the application, use the following command:
```
./gradlew bootRun
```
### Running Tests
To run the tests for the application, use the following command:
```
./gradlew test
```
