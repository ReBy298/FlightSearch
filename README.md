# Search Flights App
Search Flights App is a web application built with React TypeScript for the front-end and Spring Boot with Java 17 and Gradle for the back-end. This application utilizes the Amadeus API to search for flights. Users can search for flights and view flight details, but booking or scheduling flights is not supported.

## Prerequisites

## Front-End
NODE JS --v 22
NPM --v 10

# Back-End
Java --v 17
Spring Boot 
Gradle 

## Dockerized App
This project can be built using the docker-compose file. Both the front-end and back-end have their own Dockerfile. Below are the commands to build, run, and stop the application using either Podman or Docker.

To use this project, you might need: 

## Docker 
```
https://www.docker.com/products/docker-desktop/
```
or 
## Podman 
```
https://podman.io/docs/installation
```
on your computer. You also need to have an account in the tool you choose and the corresponding images.

## Docker/Podman Commands
### Build the Project
```
podman-compose build
``
or
`` 
docker-compose build
```
### Run the Project
```
podman-compose up
```
or
```
docker-compose up
```
### Stop the Project
```
podman-compose down
```
or
```
docker-compose down
```
## Non-Dockerized App
To run the app without Docker Compose, follow these steps. Make sure to start the back-end first.

### Back-End: Spring Boot Application
The back-end of this project is a Spring Boot application built with Java 17 and Gradle and it runs on `localhost` at port `9090`.

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
## Front-End: React TypeScript Application
The front-end of this project is a React application written in TypeScript. It runs on `localhost` at port `3000`.

### Building the Application 
To construct the application, use the following command: 
```
npm install
```
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

