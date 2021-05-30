# Spring Cloud Micro-service Architecture

![Architecture](https://user-images.githubusercontent.com/41004675/120081079-8f40ce00-c0b3-11eb-9dbe-2ec4692b747f.jpg)

## Overview
This is a demo spring micro-service architecture with the following components:
- Service Registry with *Netflix Eureka* responsible for registering all our services.
- API Gateway with *Spring Cloud Gateway* allowing for a single entrypoint to our micro-service architecture.
- User Service with *Spring Boot* for managing users with a basic CRUD API.
- Configuration Server with *Spring Config Server* which retrieves common configuration for all services that need to register with Netflix Eureka.
- Distributed Logging with *Zipkin* & *Sleuth* for troubleshooting and tracing requests. 
- Circuit Breaker with *Spring Cloud Resilience4J* for fault tolerance.


## Requirements
### Zipkin Server
Download Zipkin Server jar file from the official website.

### Configuration Server
Use my configuration repository already added to the project properties, or create your own configuration repository and attach it in `config-server` application.yml as follows:

```yml
spring:
    ...
    cloud:
        config:
            server:
                git:
                    ...
                    uri: CONFIGURATION_REPO_URL
```

## Demo
### Call to API
1. Create a user with Postman or with cURL command:
```shell
curl --location --request POST 'http://localhost:9191/users/' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "firstName": "John",
        "lastName": "Doe",
        "email": "john@example.com"
    }'
```
2. Retrieve the created user by ID:
```shell
curl --location --request GET 'http://localhost:9191/users/1'
```

### Dashboards
1. Check the state of your services in http://localhost:8761

    ![Eureka](https://user-images.githubusercontent.com/41004675/120082483-40973200-c0bb-11eb-8df6-ebc8ce4714dd.PNG)

2. Trace your requests in http://localhost:9411

    ![Zipkin](https://user-images.githubusercontent.com/41004675/120082486-468d1300-c0bb-11eb-9695-35e10f93eda7.PNG)
