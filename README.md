# TEST

## Goal
Create a small game of stone, scissors, paper. The user is able to select one of the symbols while the computer (i.e. the enemy) should pick its symbol randomly. The rules are applied and it is displayed which player wins.

## Instructions to have the backend application up and running
We provided as much as necessary to have this solution up and running.

> **_NOTE:_** IMPORTANT: We must be sure that we don't have any local application consuming port 8080

Before having the solution working, we need to:

1. [Compile the service module, create the docker image](#setup-service-module)
2. [Deploy the container](#deploy-container)

### Setup service module
We need to compile our service module, create a docker image and then deploy it. So, for that follow these steps:
1. In the project's root directory, execute this: ```.\gradlew build```
2. Once done, we need to create the docker image: ```docker build . -t game```
3. Check that, when executing ```docker images``` you have a ```game``` one

### Deploy container

1. Once done, then in project root directory, you must run ```docker-compose up -d```. You should have 1 service running: game service
2Check this link: http://localhost:8080/actuator/health. Check the status is UP.

Then you should deploy the frontend part to have your UI up and running. This can be downloaded through this repository: https://github.com/rgutialo/game-frontend

Enjoy!

### Unit Testing
This project contains unit tests (Using JUnit5 and Mockito) in order to cover all code created. In case you want to run them: just type: ```.\gradlew test```  